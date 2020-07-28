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

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private SqlSession sqlSession;

	// 게시글 등록 페이지
	@GetMapping("/insert")
	public String boardInsert() {
		return "board/insert";
	}

	// 게시글 등록 메소드
	@PostMapping("/insert")
	public String boardInsert(@ModelAttribute BoardDTO boardDTO) {
		// 시퀀스 번호 발급
		int board_no = sqlSession.selectOne("board.squence");

		// 부여받은 시퀀스 번호 == 게시글 번호 / 그룹 번호
		boardDTO.setBoard_no(board_no);
		boardDTO.setGroup_no(board_no);

		// boardDTO 객체를 DB에 전송
		sqlSession.insert("board.insert", boardDTO);

		// 게시글 작성 이후 해당 게시글로 이동
		return "board/board_detail?post_no=" + board_no;
	}

	// 전체 게시글 조회
	@GetMapping("/list")
	public String getList(Model model) {
		List<BoardDTO> list = sqlSession.selectList("board.getList");
		model.addAttribute("list", list);

		return "board/list";
	}

	// 검색 기능 구현
	@PostMapping("/search")
	public String search(Model model, @RequestParam String type, @RequestParam String keyword) {
		Map<String, String> param = new HashMap<String, String>();
		
		param.put("type", type);
		param.put("keyword", keyword);
		
		List<BoardDTO> list = sqlSession.selectList("board.search", param);
		
		model.addAttribute("list", list);
		
		return "board/list";
	}

}
