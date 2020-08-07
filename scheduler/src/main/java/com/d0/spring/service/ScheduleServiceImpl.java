package com.d0.spring.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ScheduleServiceImpl implements ScheduleService {

	@Override
	@Scheduled(initialDelay = 1000, fixedDelay = 1000)
	public void oneSec() {
		log.debug("1초에 한번씩!");
		
	}

}
