package com.d0.spring.service;

import com.d0.spring.entity.CategoryDTO;
import com.d0.spring.entity.ItemsDTO;

public interface MarketService {
	public void add(CategoryDTO categoryDTO, ItemsDTO itemsDTO);
}
