package com.d0.spring;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.d0.spring.entity.CertDTO;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringJUnit4ClassRunner.class) // Spring + Junit4 연동
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml" }) // 설정파일 위치 정보
@WebAppConfiguration // 웹과 관련된 설정 무시
@Slf4j
public class Test05 {

	@Autowired
	private SqlSession sqlSession;

	@Test
	public void test() {
		CertDTO test = CertDTO.builder().who("127.0.0.1").secret("359038").build();
		CertDTO certDto = sqlSession.selectOne("cert.check2", test);
		if(certDto != null) {
			log.debug("certDTO = {}", certDto.toString());
		}
		else {
			log.debug("없음");
		}
	}
}
