package com.d0.gallery.service;

import java.io.File;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.d0.gallery.entity.GalleryDTO;
import com.d0.gallery.repository.GalleryDAO;
import com.d0.gallery.vo.GalleryVO;

@Service
public class GalleryServiceImpl implements GalleryService {

	@Autowired
	private GalleryDAO galleryDAO;

	// 사진 DB 등록 + 하드 디스크에 저장
	@Override
	public void insert(GalleryDTO galleryDTO, GalleryVO galleryVO) throws Exception {

		if (galleryVO.isFileExist()) {
			for (MultipartFile file : galleryVO.getF()) {
				galleryDTO.setting(file);

				long no = galleryDAO.insert(galleryDTO);

				File target = new File("/Users/d0/Desktop/Java/img", String.valueOf(no));
				file.transferTo(target);
			}
		}
	}

	// 사진 다운로드
	@Override
	public ByteArrayResource down(GalleryDTO galleryDTO) throws Exception {

		if (galleryDTO == null) {
			return null;
		} else {
			File target = new File("/Users/d0/Desktop/Java/img", String.valueOf(galleryDTO.getNo()));
			byte[] data = FileUtils.readFileToByteArray(target);
			ByteArrayResource res = new ByteArrayResource(data);

			return res;
		}

	}

	// 사진 단일 조회
	@Override
	public GalleryDTO get(long no) {

		return galleryDAO.get(no);
	}

	// 전체 사진 조회
	@Override
	public List<GalleryDTO> getList() {

		return galleryDAO.getList();
	}

}
