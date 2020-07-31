package com.d0.spring.repository;

import com.d0.spring.entity.GallaryDTO;

public interface GallaryDAO {
	long seq();
	void insert(GallaryDTO gallaryDTO);
}
