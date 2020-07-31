package com.d0.spring.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.d0.spring.entity.GallaryDTO;

@Repository
public class GallaryDAOImpl implements GallaryDAO {

	@Autowired
	private SqlSession sqlSession;

	@Override
	public long seq() {
		return sqlSession.selectOne("file.seq");
	}

	@Override
	public long insert(GallaryDTO gallaryDTO) {
		gallaryDTO.setNo(this.seq());

		sqlSession.insert("file.insert", gallaryDTO);

		return gallaryDTO.getNo();
	}
	
	// 다운로드
	@Override
	public GallaryDTO get(long no) {
		GallaryDTO gallaryDTO = sqlSession.selectOne("file.get", no);
		return gallaryDTO;
	}
}
