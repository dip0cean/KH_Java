package DB.Beans;

import java.util.Scanner;

public class Test03 {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		ProductDTO pdto = new ProductDTO();
		ProductDAO pdao = new ProductDAO();

		System.out.println("제품명 : ");
		pdto.setName(sc.nextLine());

		System.out.println("종류 : ");
		pdto.setType(sc.nextLine());

		System.out.println("가격 : ");
		pdto.setPrice(sc.nextInt());

		sc.nextLine();

		System.out.println("제조일 : ");
		pdto.setMade(sc.nextLine());

		System.out.println("유통기한 : ");
		pdto.setExpire(sc.nextLine());

		sc.close();

		pdao.regist(pdto);

	}

}
