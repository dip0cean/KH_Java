package DB.Beans;

import java.util.List;

public class Test05 {

	public static void main(String[] args) throws Exception {
//		목표 > ProductDAO 를 이용하여 상품 목록을 구한 뒤 출력
		ProductDAO pdao = new ProductDAO();
		List<ProductDTO> list = pdao.getList();

//		list 안에는 ProductDto(상품정보) 들이 존재한다.
		System.out.println("상품 개수 : " + list.size());

//		전체 목록을 확인하고 싶다면 반복문을 이용
		for (ProductDTO pdto : list) {
			System.out.println(pdto.getName() + " : " + pdto.getPrice());
		}

	}
}
