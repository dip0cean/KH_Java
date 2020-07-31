package com.kh.quiz.repository;

import java.util.List;
import java.util.Map;

import com.kh.quiz.entity.ProductDTO;

public interface ProductDAO {
	
	// 시퀀스 발급
	int seq();
	
	// 상품 등록
	boolean regist(ProductDTO productDTO);
	
	// 상품 수정
	void edit(ProductDTO productDTO);
	
	// 상품 삭제
	void delete(ProductDTO productDTO);
	
	// 상품 리스트 + 검색
	List<ProductDTO> listSearch(Map<String, Object> map);
	
	// 상품 상세 페이지
	ProductDTO detail(long no);
}
