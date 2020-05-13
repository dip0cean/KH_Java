package Api.Lang.String_1;

import java.util.Scanner;

public class Test03 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		User[] data = new User[3];
		data[0] = new User("tester", "test1234");
		data[1] = new User("master", "master1234");
		data[2] = new User("user", "user1234");

//		사용자 입력
		System.out.print("아이디 > ");
		String id = sc.nextLine();
		System.out.print("비밀번호 > ");
		String pw = sc.nextLine();
		sc.close();

		LoginManger manger = new LoginManger();
		if (manger.login(id, pw)) {
			System.out.println("로그인 성공");
		} else {
			System.out.println("로그인 실패");
		}
	}

}
