package com.d0.spring.controller;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.d0.spring.entity.BoardDTO;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private SqlSession sqlSession;

	// 게시글 등록 (get)
	@GetMapping("/insert")
	public String postInsert() {
		return "board/insert";
	}

	// 게시글 등록 (post)
	@PostMapping("/insert")
	public String postInsert(@ModelAttribute BoardDTO boardDTO) {
		sqlSession.insert("board.insert", boardDTO);

		return "redirect:board_detail";
	}

	// 상세 게시글 > 어떻게 하면 해당 게시글 번호 받아올지 생각
	@GetMapping("/detail")
	public String postDetail(Model model) {
		List<BoardDTO> list = sqlSession.selectList("getBoardDetail");
		
		model.addAttribute("getBoardDetail", list);
		
		return "board/board_detail";
	}

}
