package com.d0.gallery.service;

import java.util.List;

import org.springframework.core.io.ByteArrayResource;

import com.d0.gallery.entity.GalleryDTO;
import com.d0.gallery.vo.GalleryVO;

public interface GalleryService {

	// 사진 등록 메소드
	void insert(GalleryDTO galleryDTO, GalleryVO galleryVO)throws Exception;
	
	// 사진 다운 메소드
	ByteArrayResource down(GalleryDTO galleryDTO) throws Exception;
	
	// 단일 조회
	GalleryDTO get(long no);
	
	// 전체 사진 조회
	List<GalleryDTO> getList();
	
}
