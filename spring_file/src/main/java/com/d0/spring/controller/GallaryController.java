package com.d0.spring.controller;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.d0.spring.entity.GallaryDTO;
import com.d0.spring.repository.GallaryDAO;
import com.d0.spring.vo.GallaryVO;

@Controller
@RequestMapping("/gallary")
public class GallaryController {

	@Autowired
	private GallaryDAO gallaryDAO;

	@GetMapping("/insert")
	public String insert() {
		return "gallary/insert";
	}

	@PostMapping("/insert")
	public String insert(@ModelAttribute GallaryVO gallaryVO) throws Exception {

		if (gallaryVO.isFileExist()) {

			for (MultipartFile file : gallaryVO.getF()) {
				
				gallaryVO.setFname(file.getOriginalFilename());
				gallaryVO.setFtype(file.getContentType());
				gallaryVO.setFsize(file.getSize());
				
				GallaryDTO gallaryDTO = new GallaryDTO(gallaryVO);
				long no = gallaryDAO.insert(gallaryDTO);
				
				File target = new File("D:/upload", String.valueOf(no));
				file.transferTo(target);
			}
		}

		return "redirect:insert";
	}

}
