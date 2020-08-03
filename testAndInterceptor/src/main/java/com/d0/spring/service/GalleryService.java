package com.d0.spring.service;

import com.d0.spring.entity.GalleryDTO;
import com.d0.spring.vo.GalleryVO;

public interface GalleryService {

	boolean insert(GalleryDTO galleryDTO, GalleryVO galleryVO) throws Exception;
}
