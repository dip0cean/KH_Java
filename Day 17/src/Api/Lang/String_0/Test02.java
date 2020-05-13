package Api.Lang.String_0;

import java.util.Scanner;

public class Test02 {
	public static void main(String[] args) {
//		로그인 프로그램
//		사용자에게 아이디와 비밀번호를 입력받아 로그인 판정을 하는 프로그램 구현
//		[1]	아이디와 비밀번호 1개 > 아이디는 대소문자 무시 / 비밀번호 대소문자 구분
//			-	아이디 : khacademy / 비밀번호 : student 인 경우 로그인		
//		[2]	다음 명단에서 해당하는 정보가 있을 경우 로그인 성공 출력
//			-	아이디 : tester / 비밀번호 : test1234
//			-	아이디 : master / 비밀번호 : master1234
//			-	아이디 : user / 비밀번호 : user1234

		Scanner sc = new Scanner(System.in);

//		[1] 문제		
		System.out.print("아이디 > ");
		String id = sc.nextLine();
		System.out.print("패스워드 > ");
		String pw = sc.nextLine();

		if (id.equalsIgnoreCase("khacademy") && pw.equals("student")) {
			System.out.println("System > 로그인 성공");
		} else {
			System.out.println("System > 로그인 실패");
		}

		System.out.println();

//		[2] 문제
		int a = 1;
		int b = 2;
		String[][] data = new String[a][b];

		for (int i = 0; i < data.length; i++) {
			System.out.println("아이디와 패스워드를 입력하세요.");
			for (int k = 0; k < data[i].length; k++) {
				data[i][k] = sc.nextLine();
			}
		}
		sc.close();
		String idstr = "불일치";
		String pwstr = "불일치";

		for (int i = 0; i < data.length; i++) {
			switch (data[i][i]) {
			case "tester":
				idstr = "일치";
				break;
			case "master":
				idstr = "일치";
				break;
			case "user":
				idstr = "일치";
				break;
			default:
				idstr = "불일치";
				break;

			}
			switch (data[i][i + 1]) {
			case "test1234":
				pwstr = "일치";
				break;
			case "master1234":
				pwstr = "일치";
				break;
			case "user1234":
				pwstr = "일치";
				break;
			default:
				pwstr = "불일치";
				break;
			}
		}
		if (idstr.equals("일치") && pwstr.equals("일치")) {
			System.out.println("System > 로그인 성공");
		} else {
			System.out.println("System > 로그인 실패");
		}
	}
}
