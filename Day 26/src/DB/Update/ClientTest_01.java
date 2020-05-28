package DB.Update;

import java.util.Scanner;

public class ClientTest_01 {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);

		ClientDTO cdto = new ClientDTO();
		ClientDAO cdao = new ClientDAO();

		System.out.print("번호를 입력하세요. > ");
		cdto.setClient_no(sc.nextInt());
		System.out.print("변경할 비밀번호를 입력하세요. > ");
		cdto.setClient_pw(sc.next());
		sc.close();

		cdao.editPw(cdto);

	}

}
