package com.d0.spring.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.d0.spring.entity.ItemsDTO;

@Repository
public class ItemsDAOImpl implements ItemsDAO {
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public void add(ItemsDTO itemsDTO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ItemsDTO> getList() {
		// TODO Auto-generated method stub
		return null;
	}
}
