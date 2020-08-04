package com.d0.spring;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class test01 {

	// LoggerFactory 생성 > 로깅 수행 도구 생성(Logger)
	Logger logger = LoggerFactory.getLogger(test01.class);
	
	@Test
	public void test() {
		logger.debug("debug");
		logger.info("info");
		logger.warn("warn");
		logger.error("error");
	}
}
