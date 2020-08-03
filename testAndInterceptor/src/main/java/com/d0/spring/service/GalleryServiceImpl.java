package com.d0.spring.service;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.d0.spring.entity.GalleryDTO;
import com.d0.spring.repository.GalleryDAO;
import com.d0.spring.vo.GalleryVO;

@Service
public class GalleryServiceImpl implements GalleryService {

	@Autowired
	private GalleryDAO galleryDAO;

	@Override
	public boolean insert(GalleryDTO galleryDTO, GalleryVO galleryVO) throws Exception {

		if (galleryVO.isFileExcept()) {

			for (MultipartFile file : galleryVO.getF()) {

				galleryDTO.setting(file);

				long no = galleryDAO.insert(galleryDTO);

				File target = new File("/Users/d0/Desktop/Java/img", String.valueOf(no));
				file.transferTo(target);
			}

			return true;

		}

		return false;
	}

}
