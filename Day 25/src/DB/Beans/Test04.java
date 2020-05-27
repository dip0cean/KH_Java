package DB.Beans;

public class Test04 {

	public static void main(String[] args) throws Exception {
		ProductDAO pdao = new ProductDAO();

		int count = pdao.getCount();

		System.out.println("총 개수 : " + count);
	}
}
