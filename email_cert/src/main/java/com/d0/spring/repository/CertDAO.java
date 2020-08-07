package com.d0.spring.repository;

import com.d0.spring.entity.CertDTO;

public interface CertDAO {

	// 인증번호 발급
	public void regist(CertDTO certDTO);
	
	// 인증번호 전송
	public boolean validate(CertDTO certDTO);
}
