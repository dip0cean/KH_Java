package com.d0.spring.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.d0.spring.entity.CertDTO;

@Repository
public class CertDAOImpl implements CertDAO {

	@Autowired
	private SqlSession sqlSession;

	// 인증 번호 발급
	@Override
	public void regist(CertDTO certDTO) {
		
		sqlSession.insert("cert.regist", certDTO);

	}

	// 인증번호 인증 후 삭제
	@Override
	public boolean validate(CertDTO certDTO) {
		// 인증번호 인증
		CertDTO result = sqlSession.selectOne("cert.validate", certDTO);
		if(result != null) {
			sqlSession.delete("cert.delete",result);
		}
		// 인증번호 삭제
		return result != null;
	}

	@Override
	public int clear() {
		int result = sqlSession.delete("cert.clear");
		
		return result;
	}
}
