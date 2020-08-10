package com.d0.spring.repository;

import java.util.List;

import com.d0.spring.entity.CategoryDTO;

public interface CategoryDAO {

	public void add(CategoryDTO categoryDTO);
	public List<CategoryDTO> getList();
}
