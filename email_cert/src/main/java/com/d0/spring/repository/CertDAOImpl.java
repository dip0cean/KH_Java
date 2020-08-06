package com.d0.spring.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.d0.spring.entity.CertDTO;

@Repository
public class CertDAOImpl implements CertDAO {

	@Autowired
	private SqlSession sqlSession;

	// 인증 번호 삽입
	@Override
	public void regist(CertDTO certDTO) {
		
		sqlSession.insert("cert.regist", certDTO);

	}
}
