package com.d0.spring.controller;

import java.io.File;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.d0.spring.vo.UploadVO;

@Controller
@RequestMapping("/file")
public class FileUploadController {

	@GetMapping("/upload")
	public String upload() {

		return "file/upload";
	}

	// 1 > 파일 1개
	/*
	 * @PostMapping("/upload") public String upload(@RequestParam String
	 * uploader, @RequestParam MultipartFile f) { System.out.println("upload : " +
	 * uploader); System.out.println("f : " + f); System.out.println("파일이 있나요 ? " +
	 * !f.isEmpty());
	 * 
	 * return "redirect:upload"; }
	 */

	// 2 > 파일 여러개
	/*
	 * @PostMapping("/upload") public String upload(@RequestParam
	 * List<MultipartFile> f, @RequestParam String uploader) {
	 * System.out.println("uploader : " + uploader); System.out.println("f : " +
	 * f.size()); System.out.println("파일 여부 : " + !f.isEmpty());
	 * 
	 * return "redirect:upload"; }
	 */

	// 3 > ModelAttribute 로 받기
	@PostMapping("/upload")
	public String upload(@ModelAttribute UploadVO uploadVO) throws Exception {

		// 전달된 파일의 정보를 불러와서 저장
		// 파일 = 실체는 하드디스크에 저장, 정보는 데이터 베이스에 저장

		System.out.println(uploadVO.getF().size());
		System.out.println(uploadVO.getUploader());
		System.out.println(uploadVO.isFileExist());

		if (uploadVO.isFileExist()) {
			// 정보 추출 및 저장
			for (MultipartFile file : uploadVO.getF()) {
				System.out.println("이름 : " + file.getOriginalFilename());
				System.out.println("크기 : " + file.getSize());
				System.out.println("유형 : " + file.getContentType());

				// 대상을 지정하여 내보내기 (저장)
				File target = new File("D:/upload", file.getOriginalFilename());
				file.transferTo(target);

			}

		}

		return "redirect:upload";
	}
}
