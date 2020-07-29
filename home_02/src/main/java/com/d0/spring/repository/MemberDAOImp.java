package com.d0.spring.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import com.d0.spring.entity.MemberDTO;

@Repository
public class MemberDAOImp implements MemberDAO {

	@Autowired
	private SqlSession sqlSession;

	@Autowired
	private PasswordEncoder encoder;

	// 회원가입
	@Override
	public boolean join(MemberDTO memberDTO) {

		MemberDTO find = sqlSession.selectOne("member.getId", memberDTO.getMember_id());

		if (find == null) {
			// 가입 전 비밀번호 암호화
			// encoder.encode(비밀번호) --> 암호화된 비밀번호
			memberDTO.setMember_pw(encoder.encode(memberDTO.getMember_pw()));

			// 해당 아이디가 없다면 가입
			sqlSession.insert("member.regist", memberDTO);

			return true;
		} else {
			// 해당 아이디가 있다면 회원가입 페이지로 이동
			return false;
		}
	}

	// 로그인
	@Override
	public boolean login(MemberDTO memberDTO) {
		// 1. DB 에서 해당 회원의 정보를 모두 불러온다.
		MemberDTO find = sqlSession.selectOne("member.getId", memberDTO.getMember_id());

		if (find != null) {
			// 2. 아이디가 있을 경우 비밀번호 비교를 수행한다. (encoder 이용)
			// encoder.matches(입력pw, dbpw);
			boolean pass = encoder.matches(memberDTO.getMember_pw(), find.getMember_pw());

			if (pass) {
				// 3. 비밀번호 비교
				return true;
			}
		}

		return false;
	}

	// 관리자 - 회원목록 리스트
	@Override
	public List<MemberDTO> getList() {
		
		List<MemberDTO> list = sqlSession.selectList("member.getList");

		return list;
	}

}
