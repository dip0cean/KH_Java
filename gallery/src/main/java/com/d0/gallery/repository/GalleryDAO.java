package com.d0.gallery.repository;

import java.util.List;

import com.d0.gallery.entity.GalleryDTO;

public interface GalleryDAO {

	// 시퀀스 발급 + 사진 등록
	long insert(GalleryDTO galleryDTO);
	
	// 사진 단일 조회
	GalleryDTO get(long no);
	
	// 전체 사진 조회
	List<GalleryDTO> getList();
}
