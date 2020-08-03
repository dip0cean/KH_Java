package com.d0.gallery.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.d0.gallery.entity.GalleryDTO;

@Repository
public class GalleryDAOImpl implements GalleryDAO {

	@Autowired
	private SqlSession sqlSession;

	// 시퀀스 발급 + 사진 등록
	@Override
	public long insert(GalleryDTO galleryDTO) {

		galleryDTO.setNo(sqlSession.selectOne("gallery.seq"));

		sqlSession.insert("gallery.insert", galleryDTO);

		return galleryDTO.getNo();
	}

	// 사진 단일 조회
	@Override
	public GalleryDTO get(long no) {
		GalleryDTO galleryDTO = sqlSession.selectOne("gallery.get", no);
		
		return galleryDTO;
	}

	// 전체 사진 조회
	@Override
	public List<GalleryDTO> getList() {
		
		return sqlSession.selectList("gallery.list");
	}

}
