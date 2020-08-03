package com.d0.spring.repository;

import com.d0.spring.entity.MemberDTO;

public interface MemberDAO {
	// 회원 가입 
	int join(MemberDTO memberDto);
}
