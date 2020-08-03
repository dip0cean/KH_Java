package com.d0.spring.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.d0.spring.entity.MemberDTO;

@Repository
public class MemberDAOImpl implements MemberDAO{

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int join(MemberDTO memberDto) {
		// 시퀀스 발급 
		int no = sqlSession.selectOne("member.seq");
		
		// DTO 에 시퀀스 번호 삽입 
		memberDto.setNo(no);
		
		// 해당 회원 등록 
		sqlSession.insert("member.join", memberDto);
		
		return no;
	}

}
