package DB.Task;

import java.util.List;
import java.util.Scanner;

public class ClientTest_03 {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.print("조회할 아이디를 입력해주세요. > ");
		String id = sc.next();
		sc.close();

		ClientDAO cdao = new ClientDAO();
		List<ClientDTO> list = cdao.getList(id);

		if (list.size() != 0) {
			System.out.println("Num\t|  " + "ID\t\t|\t" + "POINT");
			System.out.println("-----------------------------------------");

			for (ClientDTO cdto : list) {
				System.out.println(cdto.getNumber() + "\t|  " + cdto.getId() + "\t|\t" + cdto.getPoint());
			}
		} else {
			System.out.println("아이디를 찾을 수 없습니다.");
		}

	}

}
