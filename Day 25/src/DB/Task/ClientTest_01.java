package DB.Task;

import java.util.Scanner;

public class ClientTest_01 {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		ClientDTO cdto = new ClientDTO();
		ClientDAO cdao = new ClientDAO();

		System.out.print("아이디 > ");
		cdto.setId(sc.nextLine());
		System.out.print("패스워드 > ");
		cdto.setPw(sc.nextLine());
		sc.close();

		cdao.regist(cdto);
	}
}
