package Api.Collection_2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test02 {

	public static void main(String[] args) {
//		로그인 프로그램 만들기
//		-	회원 정보를 보관할 Map 을 만들어서 다음 정보를 먼저 저장하십시오.
//		-	아이디 / 비밀번호
//		-	사용자에게 아이디와 비밀번호를 입력받아 로그인 성공 또는 실패 메세지를 화면에 출력하도록 구현
		Scanner sc = new Scanner(System.in);

		Map<String, String> user = new HashMap<String, String>();
		user.put("test", "test1234");
		user.put("user", "user1234");
		user.put("master", "master1234");

		System.out.print("아이디 > ");
		String id = sc.nextLine();
		System.out.print("비밀번호 > ");
		String pw = sc.nextLine();
		sc.close();

		if (user.containsKey(id) && user.containsValue(pw)) {
			System.out.println("로그인 성공");
		} else {
			System.out.println("로그인에 실패했습니다. 아이니 혹은 비밀번호를 확인해주세요.");
		}
	}
}
