package com.d0.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/file")
public class FileUploadController {

	@GetMapping("/upload")
	public String upload() {

		return "file/upload";
	}

}
