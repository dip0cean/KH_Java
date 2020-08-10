package com.d0.spring.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.d0.spring.entity.CategoryDTO;
import com.d0.spring.entity.ItemsDTO;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MarketServiceImpl implements MarketService {
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	@Transactional // 해당 메소드 트랜잭션으로 등록
	public void add(CategoryDTO categoryDTO, ItemsDTO itemsDTO) {
		
		sqlSession.insert("category.add", categoryDTO);
		log.info("a 성공");
		sqlSession.insert("item.add", itemsDTO);
		log.info("b 성공");		
	}

}
