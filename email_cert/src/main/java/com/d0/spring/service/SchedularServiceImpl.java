package com.d0.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.d0.spring.repository.CertDAO;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class SchedularServiceImpl implements SchedularService {

	@Autowired
	private CertDAO certDAO;
	
	@Override
	@Scheduled(cron = "* * * * * *")
	public void clear() {
		
		int result = certDAO.clear();
		
		if(result == 1)	{
			log.debug("쓰레기 인증번호 삭제 완료!"); 
			return;
		}
		
		log.debug("버릴 쓰레기 없음!");
	}

}
