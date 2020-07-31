package com.d0.spring.service;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.d0.spring.entity.GallaryDTO;
import com.d0.spring.repository.GallaryDAO;
import com.d0.spring.vo.GallaryVO;

@Service
public class GallaryServiceImpl implements GallaryService {

	@Autowired
	private GallaryDAO gallaryDAO;

	@Override
	public void add(GallaryDTO gallaryDTO, GallaryVO gallaryVO) throws Exception {

		if (gallaryVO.isFileExist()) {

			for (MultipartFile file : gallaryVO.getF()) {
				
				gallaryDTO.settingDB(file);

				long no = gallaryDAO.insert(gallaryDTO);

				File target = new File("D:/upload", String.valueOf(no));
				file.transferTo(target);
			}
		}
	}
}
