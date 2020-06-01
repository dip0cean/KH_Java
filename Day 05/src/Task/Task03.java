package Task;

import java.util.Scanner;

public class Task03 {

	public static void main(String[] args) {
// 		사용자에게 "닉네임" 입력받는 프로그램 구현
//		입력받은 "닉네임"을 화면에 출력 / 닉네임이 우리 기준에 맞는지 검사 결과 출력
//		(기준) 2글자 이상 8글자 이하 true
//		(출력) 사용자가 입력한 닉네임, 닉네임의 글자수, 판정결과
		
//		Scanner 도구 선언		
		Scanner sc = new Scanner(System.in);

//		닉네임 입력 (String 타입)
		System.out.println("닉네임을 입력해주세요. >");
		String nickname = sc.next();

//		비교 연산자를 통한 글자수 비교 ( 2 <= nickname <= 8)
		boolean check = (2<=nickname.length()) && (8 >= nickname.length());
		
//		결과 출력		
		System.out.println("입력한 닉네임 : 	" + nickname);
		System.out.println("닉네임 글자수 : 	" + nickname.length());
		System.out.println("사용 가능 여부 : 	" + check);
		
//		Scanner 도구 종료	
		sc.close();
	}

}
