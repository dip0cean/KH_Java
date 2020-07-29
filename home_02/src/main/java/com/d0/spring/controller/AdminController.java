package com.d0.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.d0.spring.entity.MemberDTO;
import com.d0.spring.repository.MemberDAO;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private MemberDAO memberDAO;
	
	@GetMapping("/list")
	public String getList(Model model) {
		
		List<MemberDTO> list = memberDAO.getList();
		
		model.addAttribute("getList", list);
		
		return "admin/list";
	}

}
