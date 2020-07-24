package com.d0.spring_06.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.d0.spring_06.entity.BoardDTO;

@Controller
@RequestMapping("/board") // board 공동 주소
public class BoardController {

	@GetMapping("/post")
	public String write() {
		return "redirect:/board/post";
	}

	@PostMapping("/post")
	public String post(@ModelAttribute BoardDTO bdto, HttpServletRequest req, HttpServletResponse resp)
			throws Exception {
		req.setAttribute("post", bdto);

		return "post";
	}
}
