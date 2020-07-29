package com.d0.spring.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.d0.spring.entity.BoardDTO;

@Repository
public class BoardDAOImp implements BoardDAO {

	@Autowired
	private SqlSession sqlSession;
	
	// 게시글 작성
	@Override
	public int boardWrite(BoardDTO boardDTO) {
		// 시퀀스 번호 발급
		int board_no = sqlSession.selectOne("board.squence");

		// 부여받은 시퀀스 번호 == 게시글 번호 / 그룹 번호
		boardDTO.setBoard_no(board_no);
		boardDTO.setGroup_no(board_no);

		// boardDTO 객체를 DB에 전송
		sqlSession.insert("board.insert", boardDTO);

		// 게시글 작성 이후 해당 게시글 번호를 컨트롤러로 반환
		return board_no;
	}

	// 전체 게시글 조회
	@Override
	public List<BoardDTO> getList() {
		List<BoardDTO> list = sqlSession.selectList("board.getList");
		
		return list;
	}

	// 게시글 검색
	@Override
	public List<BoardDTO> search(Map<String, String> param) {
		List<BoardDTO> list = sqlSession.selectList("board.search", param);
		
		return list;
	}

	// 게시글 리스트 + 검색
	@Override
	public List<BoardDTO> union(Map<String, Object> param) {
		List<BoardDTO> list = sqlSession.selectList("board.unionList", param);
		
		return list;
	}
}
