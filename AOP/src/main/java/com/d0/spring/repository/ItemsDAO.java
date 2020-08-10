package com.d0.spring.repository;

import java.util.List;

import com.d0.spring.entity.ItemsDTO;

public interface ItemsDAO {

	public void add(ItemsDTO itemsDTO);
	public List<ItemsDTO> getList();
}
