package com.d0.spring;

import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Test01 {
	// 목표 : Student 객체를 문자열로 변환

	@Test
	public void test() throws Exception {
		Student stu = new Student();
		stu.setName("박도요새");
		stu.setScore(100); 

		// jackson 의 도구를 사용하여 변환
		ObjectMapper mapper = new ObjectMapper();
		String value = mapper.writeValueAsString(stu);
		log.info("value = {}", value);
	}
}
