package com.d0.spring;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.d0.spring.entity.CategoryDTO;
import com.d0.spring.entity.ItemsDTO;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringJUnit4ClassRunner.class) // Spring + Junit4 연동
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml" }) // 설정파일 위치 정보
@WebAppConfiguration // 웹과 관련된 설정 무시
@Slf4j
public class Test01 {

	@Autowired
	private SqlSession sqlSession;
	
	@Test
	public void test() {
		CategoryDTO a = CategoryDTO.builder().c_no(2).c_name("식료품").build();
		ItemsDTO b = ItemsDTO.builder().i_no(2).i_name("맛있는 대패 삼겹살").c_no(a.getC_no()).build();
		
		sqlSession.insert("test.a", a);
		log.info("a 성공");
		sqlSession.insert("test.b", b);
		log.info("b 성공");
	}
}
