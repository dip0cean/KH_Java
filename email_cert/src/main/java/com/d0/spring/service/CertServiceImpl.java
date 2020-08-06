package com.d0.spring.service;

import java.text.DecimalFormat;
import java.text.Format;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.d0.spring.entity.CertDTO;
import com.d0.spring.repository.CertDAO;

@Service
public class CertServiceImpl implements CertService {

	@Autowired
	private CertDAO certDAO;
	
	// 랜덤 번호 추출 클래스
	private Random r = new Random();

	// 인증 번호 만들기
	@Override
	public String generateCode() {
		
		int n = r.nextInt(1000000);
		Format f = new DecimalFormat("000000");
		
		String code = f.format(n);
		
		
		/* certDAO.regist(certDTO); */
		
		return code;
	}

	// 아이피 + 인증 번호 > DB 에 등록
	@Override
	public String generateCertification(String ip) {
		String code = this.generateCode();
		
		CertDTO certDTO = CertDTO.builder().who(ip).secret(code).build();
		
		certDAO.regist(certDTO);
		
		return code;
	}
}
