package com.kh.quiz.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.quiz.entity.ProductDTO;

@Repository
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	private SqlSession sqlSession;
	
	// 시퀀스 발급
	@Override
	public int seq() {
		int seq = sqlSession.selectOne("seq");
		
		return seq;
	}

	// 상품 등록
	@Override
	public boolean regist(ProductDTO productDTO) {
		// 이름 / 종류를 검색
		ProductDTO compare = sqlSession.selectOne("compare", productDTO);

		if (compare != productDTO) {			
			// 해당 종류에 같은 이름이 없을 경우 등록
			// 시퀀스 번호 발급
			int seq = this.seq();
			// productDTO 에 시퀀스 번호 삽입
			productDTO.setNo(seq);
			sqlSession.insert("regist", productDTO);
			// true 값 반환
			return true;
		}

		// false 값 반환
		return false;
	}

	// 상품 수정
	@Override
	public void edit(ProductDTO productDTO) {
		sqlSession.update("edit", productDTO);
	}

	// 상품 삭제
	@Override
	public void delete(ProductDTO productDTO) {
		sqlSession.delete("delete", productDTO);
	}

	// 상품 리스트 + 검색
	@Override
	public List<ProductDTO> listSearch(Map<String, Object> map) {
		List<ProductDTO> list = sqlSession.selectList("listSearch", map);

		return list;
	}

	// 상품 상세
	@Override
	public ProductDTO detail(long no) {
		ProductDTO product = sqlSession.selectOne("get", no);
		
		return product;
	}

}
