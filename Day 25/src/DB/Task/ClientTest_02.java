package DB.Task;

import java.util.List;

public class ClientTest_02 {

	public static void main(String[] args) throws Exception {
		
//		전체 조회 프로그램		
		ClientDAO cdao = new ClientDAO();
		List<ClientDTO> list = cdao.getList();

		System.out.println("Num\t|  " + "ID\t\t|\t" + "POINT");
		System.out.println("-----------------------------------------");
		for (ClientDTO cdto : list) {
			System.out.println(cdto.getNumber() + "\t|  " + cdto.getId() + "\t|\t" + cdto.getPoint());
		}
	}
}
