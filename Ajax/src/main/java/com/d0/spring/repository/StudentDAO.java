package com.d0.spring.repository;

import java.util.List;

import com.d0.spring.entity.StudentDTO;

public interface StudentDAO {

	// 학생 등록 
	public void insert(StudentDTO studentDTO);
	
	// 학생 전체 조회 
	public List<StudentDTO> getList();
	
	// 학생 단일 조회 
	public StudentDTO get(String name);
	
	// 점수 별 학생 리스트 
	public List<StudentDTO> getScoreList(int start, int finish);
}
