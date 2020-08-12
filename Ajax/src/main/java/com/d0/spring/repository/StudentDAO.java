package com.d0.spring.repository;

import java.util.List;

import com.d0.spring.entity.StudentDTO;

public interface StudentDAO {

	public void insert(StudentDTO studentDTO);
	
	public List<StudentDTO> getList();
	
	public StudentDTO get(String name);
}
