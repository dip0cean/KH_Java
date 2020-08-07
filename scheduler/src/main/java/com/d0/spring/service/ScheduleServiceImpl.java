package com.d0.spring.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ScheduleServiceImpl implements ScheduleService {

	@Override
//	@Scheduled(initialDelay = 1000, fixedDelay = 1000) // 1초에 한번
//	@Scheduled(cron = "* * * * * *") // 매 초마다
//	@Scheduled(cron = "*/2 * * * * *") // 매 2초마다
//	@Scheduled(cron = "10-20 * * * * *") // 10 ~ 20 초 사이
//	@Scheduled(cron = "0 * * * * *") // 매 0 초 마다
//	@Scheduled(cron = "0 0 * * * *") // 매시 정각마다
//	@Scheduled(cron = "0 0 0 * * *") // 매일 자정마다
//	@Scheduled(cron = "0 0 6 * * *") // 매일 아침 6시마다
//	@Scheduled(cron = "0 0 7 1 * *") // 매월 1일 아침 7시 마다
	@Scheduled(cron = "* * * ? * fri") // 매월 금요일 매초마다
	public void oneSec() {
		log.debug("스케쥴러");
		
	}

}
