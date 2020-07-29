package com.d0.spring.repository;

import java.util.List;
import java.util.Map;

import com.d0.spring.entity.BoardDTO;

public interface BoardDAO {
	
	// 게시글 등록
	int boardWrite(BoardDTO boardDTO);
	
	// 전체 게시글 조회
	List<BoardDTO> getList();
	
	// 게시글 검색
	List<BoardDTO> search(Map<String, String> param);
	
	// 게시글 리스트 + 검색
	List<BoardDTO> union(Map<String, Object> param);
	
	
}
