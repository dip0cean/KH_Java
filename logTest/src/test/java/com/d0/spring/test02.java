package com.d0.spring;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

// 이 클래스에서 Logging 을 하고 싶을 경우 다음의 어노테이션 추가
@Slf4j
public class test02 {

	@Test
	public void test() {
		log.debug("debug");
		log.info("info");
		log.warn("warn");
		log.error("error");
	}
}
