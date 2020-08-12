package com.d0.spring.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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

	@Override
	public StudentDTO get(String name) {

		return sqlSession.selectOne("student.get", name);
	}
	
	
}
