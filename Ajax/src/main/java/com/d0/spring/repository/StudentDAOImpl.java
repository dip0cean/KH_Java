package com.d0.spring.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.d0.spring.entity.StudentDTO;

@Repository
public class StudentDAOImpl implements StudentDAO {

	@Autowired
	private SqlSession sqlSession;

	// 학생 등록
	@Override
	public void insert(StudentDTO studentDTO) {
		sqlSession.insert("student.insert", studentDTO);		
	}

	// 학생 조회
	@Override
	public List<StudentDTO> getList() {
		
		return sqlSession.selectList("student.getList");
	}

	// 학생 단일 조회 
	@Override
	public StudentDTO get(String name) {

		return sqlSession.selectOne("student.get", name);
	}

	// 점수 별 학생 조회 
	@Override @Transactional
	public List<StudentDTO> getScoreList(int start, int finish) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("start", start);
		map.put("finish", finish);
		
		List<StudentDTO> list = sqlSession.selectList("student.section", map);
		return list;
	}
	
	
}
