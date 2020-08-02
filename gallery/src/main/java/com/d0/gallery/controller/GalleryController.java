package com.d0.gallery.controller;

import java.net.URLEncoder;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.d0.gallery.entity.GalleryDTO;
import com.d0.gallery.service.GalleryService;
import com.d0.gallery.vo.GalleryVO;

@Controller
@RequestMapping("/gallery")
public class GalleryController {

	@Autowired
	private GalleryService galleryService;

	// 사진 등록 페이지
	@GetMapping("/insert")
	public String insert() {

		return "gallery/insert";
	}

	// 사진 등록 메소드
	@PostMapping("/insert")
	public String insert(@ModelAttribute GalleryDTO galleryDTO, @ModelAttribute GalleryVO galleryVO) throws Exception {

		galleryService.insert(galleryDTO, galleryVO);

		return "redirect:list";
	}

	// 사진 다운 메소드
	@GetMapping("/down/{no}")
	public ResponseEntity<ByteArrayResource> down(@PathVariable long no) throws Exception {
		GalleryDTO galleryDTO = galleryService.get(no);

		ByteArrayResource res = galleryService.down(galleryDTO);

		if (res == null) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok().contentType(MediaType.APPLICATION_OCTET_STREAM)
					.header(org.springframework.http.HttpHeaders.CONTENT_DISPOSITION,
							"attachment; filename=\"" + URLEncoder.encode(galleryDTO.getFname(), "UTF-8") + "\"")
					.header(org.springframework.http.HttpHeaders.CONTENT_ENCODING, "UTF-8").body(res);
		}

	}

	// 사진 전체 리스트
	@RequestMapping("/list")
	public String list(Model model) {
		List<GalleryDTO> list = galleryService.getList();
		
		model.addAttribute("list", list);
		
		return "gallery/list";
	}

}
