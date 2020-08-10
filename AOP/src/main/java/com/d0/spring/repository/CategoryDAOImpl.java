package com.d0.spring.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.d0.spring.entity.CategoryDTO;

@Repository
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private SqlSession sqlSession;

	@Override
	public void add(CategoryDTO categoryDTO) {
		sqlSession.insert("category.add", categoryDTO);
	}

	@Override
	public List<CategoryDTO> getList() {
		List<CategoryDTO> list = sqlSession.selectList("category.getList");
		return list;
	}
}
