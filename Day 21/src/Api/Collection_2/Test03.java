package Api.Collection_2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test03 {

	public static void main(String[] args) {
//		1. Map 을 만들어 아이디와 비밀번호를 저장
//		2. 1번에서 만든 저장소를 이용하여 로그인 프로그램을 구현

//		1번 문제		
		Map<String, String> db = new HashMap<String, String>();
		db.put("test", "test1234");
		db.put("admin", "admin1234");
		db.put("master", "master1234");

		System.out.println(db);
		System.out.println(db.size());

//		2번 문제				
		Scanner sc = new Scanner(System.in);
		System.out.println("아이디와 비밀번호를 입력해주세요.");
		String id = sc.nextLine();
		String pw = sc.nextLine();
		
		if(db.containsKey(id) && db.get(id).equals(pw)) {
			System.out.println("로그인 성공");
		} else {
			System.out.println("로그인 실패");
		}

		sc.close();
	}
}
