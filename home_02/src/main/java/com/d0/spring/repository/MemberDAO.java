package com.d0.spring.repository;

import com.d0.spring.entity.MemberDTO;

public interface MemberDAO {

	// 회원가입
	boolean join(MemberDTO memberDTO);
	// 로그인
	boolean login(MemberDTO memberDTO);
	// 회원 목록
}
