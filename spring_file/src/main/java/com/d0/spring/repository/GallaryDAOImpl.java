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
		return sqlSession.selectOne("upload.seq");
	}

	@Override
	public void insert(GallaryDTO gallaryDTO) {
		gallaryDTO.setNo(this.seq());
		
		sqlSession.insert("upload.insert", gallaryDTO);
	}
}
