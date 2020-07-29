package com.d0.spring.repository;

import java.util.List;
import java.util.Map;

import com.d0.spring.entity.BoardDTO;

public interface BoardDAO {
	
	// 게시글 등록
	int boardWrite(BoardDTO boardDTO);
	
	// 게시글 상세 페이지
	BoardDTO boardDetail(int board_no);
	
	// 게시글 상세 페이지 > 조회수 증가
	BoardDTO boardDetailRead(int board_no);
	
	// 전체 게시글 조회
	List<BoardDTO> getList();
	
	// 게시글 검색
	List<BoardDTO> search(Map<String, String> param);
	
	// 게시글 리스트 + 검색
	List<BoardDTO> union(Map<String, Object> param);
	
	// 게시글 삭제
	boolean boardDelete(BoardDTO boardDTO);
	
}
