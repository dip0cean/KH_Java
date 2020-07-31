package com.d0.spring.service;

import com.d0.spring.entity.GallaryDTO;
import com.d0.spring.vo.GallaryVO;

public interface GallaryService {
	void add(GallaryDTO gallaryDTO, GallaryVO gallaryVO) throws Exception;
}
