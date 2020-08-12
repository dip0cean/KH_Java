package com.d0.spring.rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
// RestController 는 요청에 따른 데이터를 전송하는 도구

import com.d0.spring.entity.StudentDTO;
import com.d0.spring.repository.StudentDAO;

@RestController
@RequestMapping("/test")
public class TestController {

	@Autowired
	private StudentDAO studentDAO;
	
	@Autowired
	private SqlSession sqlSession;

	@GetMapping("/")
	public String test() {
		return "Hello Rest Controller";
	}

	// 클라이언트가 데이터가 필요하다고 할 때 주로 어떤 것을 필요로 할까?
	// - 단순한 결과 > O/X > Boolean(x) > String
	// - 데이터 목록(List...) > 해당하는 형태 그대로 사용 > RestController 에서 String <-> 클래스로 변환
	// - Object / Map > 해당하는 형태 그대로 사용 > String 변환
	// -- 원시 형태를 제외한 모든 형태를 그대로 사용한다.

	@GetMapping("/test1")
	public Boolean test1() {
		return true;
	}

	@GetMapping("/test2")
	public int test2() {
		return 123;
	}

	@GetMapping("/test3")
	public float test3() {
		return 1234.4f;
	}

	@GetMapping("/test4")
	public List<String> test4() {
		List<String> list = new ArrayList<String>();

		list.add("김퍼피");
		list.add("냠냠굿");
		list.add("김두리안");

		return list;
	}

	@GetMapping("/test5")
	public Map<String, Object> test5() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", "김퍼피");
		map.put("score", 50);
		return map;
	}

	@GetMapping("/test6")
	public StudentDTO test6() {

		StudentDTO student = StudentDTO.builder().name("욜랄리").age(10).score(1010).when("어제").build();

		return student;
	}

	@GetMapping("/test7")
	public Map<String, Object> test7() {

		Map<String, Object> map = new HashMap<String, Object>();
		List<StudentDTO> list = studentDAO.getList();

		for (int i = 0; i < list.size(); i++) {
			map.put(String.valueOf(i), list.get(i));
		}

		return map;
	}

	// 학생명 조회 > 비동기 요청 중복확인 응용 가능
	@GetMapping("/test8")
	public StudentDTO test8(@RequestParam String name) {
		StudentDTO student = studentDAO.get(name);

		return student;
	}

	@GetMapping("/test9")
	public List<StudentDTO> test9() {
		List<StudentDTO> list = studentDAO.getList();
		
		return list;
	}
	
	@GetMapping("/test10")
	public List<StudentDTO> test10(@RequestParam int start, @RequestParam int finish) {
	
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("start", start);
		map.put("finish", finish);
		
		List<StudentDTO> list = sqlSession.selectList("student.section", map);
		
		return list;
	}
}
