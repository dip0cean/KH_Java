package com.d0.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.d0.spring.entity.MemberDTO;
import com.d0.spring.repository.MemberDAO;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDAO memberDAO;
	
	@Override
	public int join(MemberDTO memberDTO) {
		
		memberDAO.join(memberDTO);
		
		return 0;
	}

}
