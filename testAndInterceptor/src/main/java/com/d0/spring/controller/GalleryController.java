package com.d0.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.d0.spring.entity.GalleryDTO;
import com.d0.spring.service.GalleryService;
import com.d0.spring.vo.GalleryVO;

@Controller
@RequestMapping("/gallery")
public class GalleryController {

	@Autowired
	private GalleryService galleryService;

	@GetMapping("/insert")
	public String insert() {
		return "gallery/insert";
	}

	@PostMapping("/insert")
	public String insert(@ModelAttribute GalleryDTO galleryDTO, @ModelAttribute GalleryVO galleryVO) throws Exception {

		boolean result = galleryService.insert(galleryDTO, galleryVO);

		
		if(result) {
			
			return "redirect:home";
		
		}
		
		return "redirect:insert";
		
	}

}
