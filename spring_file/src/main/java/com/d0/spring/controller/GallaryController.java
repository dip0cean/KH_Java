package com.d0.spring.controller;

import java.io.File;
import java.net.URLEncoder;

import javax.swing.text.AbstractDocument.Content;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.d0.spring.entity.GallaryDTO;
import com.d0.spring.repository.GallaryDAO;
import com.d0.spring.service.GallaryService;
import com.d0.spring.vo.GallaryVO;

@Controller
@RequestMapping("/gallary")
public class GallaryController {

	@Autowired
	private GallaryService gallarySerivce;

	@Autowired
	private GallaryDAO gallaryDAO;

	@GetMapping("/insert")
	public String insert() {
		return "gallary/insert";
	}

	@PostMapping("/insert")
	public String insert(@ModelAttribute GallaryDTO gallaryDTO, @ModelAttribute GallaryVO gallaryVO) throws Exception {

		gallarySerivce.add(gallaryDTO, gallaryVO);

		return "redirect:insert";
	}

	/*
	 * 다운로드를 위한 컨트롤러 구현 - 다운로드는 사용자가 JSP 페이지를 받지 않는다. - 사용자가 올려둔 파일을 응답으로 제공해야 한다. -
	 * Spring 에서는 기존 방식과 Spring 방식 모두를 지원
	 */

	// case 1 > Response 정보를 이용하여 파일을 전송
	/*
	 * @GetMapping("/down/{no}")
	 * 
	 * @ResponseBody // 응답에 있어서 자동으로 처리되는 도구들을 제거 public void
	 * download(HttpServletResponse resp, @PathVariable long no) throws Exception {
	 * GallaryDTO gallaryDTO = gallaryDAO.get(no);
	 * 
	 * // 파일 정보가 없으면 사용자에게 404 Notfound 를 알린다. if (gallaryDTO == null) {
	 * resp.sendError(404); return; }
	 * 
	 * resp.setHeader("Content-Type", "application/octet-stream; charset=UTF-8");
	 * resp.setHeader("Content-Disposition", "attachment; filename=|" +
	 * URLEncoder.encode(gallaryDTO.getFname(), "UTF-8"));
	 * resp.setHeader("Content-Length", String.valueOf(gallaryDTO.getFsize()));
	 * 
	 * // 파일 정보가 있으면 파일 정보와 내용을 전달한다. File target = new File("D:/upload",
	 * String.valueOf(no)); byte[] data = FileUtils.readFileToByteArray(target);
	 * resp.getOutputStream().write(data); }
	 */

	// case 2 > Spring 에서 권장하는 방식 (DispatcherServlet 이용)
	// - ResponseEntity > 응답 정보가 모여있는 개체
	@GetMapping("/down/{no}")
	public ResponseEntity<ByteArrayResource> down(@PathVariable int no) throws Exception {
		GallaryDTO gallaryDTO = gallaryDAO.get(no);
		
		if(gallaryDTO == null) {
			return ResponseEntity.notFound().build();
		} else {
			File target = new File("D:/upload" , String.valueOf(no));
			byte[] data = FileUtils.readFileToByteArray(target);
			ByteArrayResource res = new ByteArrayResource(data);
			
			return ResponseEntity
					.ok()
					.contentType(
					MediaType.APPLICATION_OCTET_STREAM)
					.contentLength(gallaryDTO.getFsize())
					.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\""+URLEncoder.encode(gallaryDTO.getFname(), "UTF-8")+"\"")
					.header(HttpHeaders.CONTENT_ENCODING, "UTF-8")
					.body(res);
		}
	}

}
