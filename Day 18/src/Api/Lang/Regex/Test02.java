package Api.Lang.Regex;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Test02 {
	public static void main(String[] args) {
//		사용자에게 아이디와 비밀번호를 입력받아 올바른 형식인지 검사 후 출력
//		-	아이디 : 영문 소문자 숫자, - , _ 를 이용하여 5 ~ 20 이내로 작성
//		-	패스워드 : 영문 대/소문자와 숫자, - , _ 를 이용하여 8 ~ 16 이내로 작성
		Scanner sc = new Scanner(System.in);

		System.out.print("아이디를 입력해주세요. > \nID : ");
		String id = sc.nextLine();
		System.out.println("패스워드를 입력해주세요. > \nPW :");
		String pw = sc.nextLine();
		sc.close();

		String regid = "^[a-z0-9\\-_]{6,21}$"; // 아이디 비교
		String regpw = "^[a-z0-9\\-_]{9,17}$"; // 패스워드 비교
		// [1]	^\w$ : 전세계 공통 단어
		// [2] ^\d$ : 0 ~ 9


		if (Pattern.matches(regid, id)) {
			System.out.println("System > ");
			System.out.println("아이디가 올바른 형식입니다.");
		} else {
			System.out.println("System > ");
			System.out.println("아이디는 영문 소문자 / 숫자 / - / _ 를 이용해서 5 ~ 20자 내로 생성 가능합니다.");
		}

		if (Pattern.matches(regpw, pw)) {
			System.out.println("System > ");
			System.out.println("패스워드가 올바른 형식입니다.");
		} else {
			System.out.println("System > ");
			System.out.println("패스워드는 영문 대소문자 / 숫자 / 특수문자를 이용해 8 ~ 16 자 내로 생성 가능합니다.");
		}
	}
}
