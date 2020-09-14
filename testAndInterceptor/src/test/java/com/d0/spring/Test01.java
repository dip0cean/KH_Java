package com.d0.spring;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

public class Test01 {
	/*
	 * 
	 */
	MockMvc mock;

	@Before
	public void prepare() {
		// mock = 가짜 test 컨트롤러
		// 테스트하고자 하는 독립 모듈을 mock 에 선언
		mock = MockMvcBuilders.standaloneSetup(new TestController()).build();
	}

	@Test
	public void test() throws Exception {
		mock.perform(get("/test")).andDo(print()).andExpect(status().is2xxSuccessful()).andReturn();
	}
}
