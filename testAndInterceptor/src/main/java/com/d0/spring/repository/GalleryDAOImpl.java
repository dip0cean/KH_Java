package com.d0.spring.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.d0.spring.entity.GalleryDTO;

@Repository
public class GalleryDAOImpl implements GalleryDAO{

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public long insert(GalleryDTO galleryDTO) {
		
		int no = sqlSession.selectOne("gallery.seq");
		
		galleryDTO.setNo(no);
		
		sqlSession.insert("gallery.insert", galleryDTO);
		
		return no;
	}

}
