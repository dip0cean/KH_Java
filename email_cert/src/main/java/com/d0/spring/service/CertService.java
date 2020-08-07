package com.d0.spring.service;

public interface CertService {

	// 인증번호 생성
	public String generateCode();
	
	// 인증번호 생성 후 DB 등록
	public String generateCertification(String ip);

}
