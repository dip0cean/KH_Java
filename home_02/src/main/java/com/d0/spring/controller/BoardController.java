package com.d0.spring.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.d0.spring.entity.BoardDTO;
import com.d0.spring.repository.BoardDAO;
import com.d0.spring.repository.BoardDAOImp;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private SqlSession sqlSession;
	
	@Autowired
	private BoardDAO boardDAO;

	// 게시글 등록 페이지
	@GetMapping("/insert")
	public String boardInsert() {
		return "board/insert";
	}

	// 게시글 등록 메소드
	@PostMapping("/insert")
	public String boardInsert(@ModelAttribute BoardDTO boardDTO) {
		int board_no = boardDAO.boardWrite(boardDTO);
		
		return "board/board?board_no=" + board_no;
	}

	// 전체 게시글 조회
	@GetMapping("/list")
	public String getList(Model model) {
		List<BoardDTO> list = boardDAO.getList();
		model.addAttribute("list", list);

		return "board/list";
	}

	// 검색 기능 구현
	@PostMapping("/search")
	public String search(Model model, @RequestParam String type, @RequestParam String keyword) {

		Map<String, String> param = new HashMap<String, String>();

		param.put("type", type);
		param.put("keyword", keyword);

		List<BoardDTO> list = boardDAO.search(param);

		model.addAttribute("list", list);

		return "board/list";
	}

	// 게시글 리스트 + 검색 기능 구현
	@RequestMapping("/union")
	public String union(Model model, @RequestParam(required = false) String type, @RequestParam(required = false) String keyword) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("type", type);
		map.put("keyword", keyword);
		
		List<BoardDTO> list = boardDAO.union(map);
		
		model.addAttribute("list", list);
		
		return "board/list";
	}

}
