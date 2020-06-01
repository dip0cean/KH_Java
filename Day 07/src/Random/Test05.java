package Random;

import java.util.Random;
import java.util.Scanner;

public class Test05 {

	public static void main(String[] args) {
//		구구단 문제
//		프로그램 시작 시 사용자에게 랜덤하게 구구단 문제를 하나 출제합니다.
//		사용자에게 정답을 입력 받아 "정답" 인지 "오답" 인지 판정해서 출력합니다.

//		Random / Scanner 도구 선언
		Random r = new Random();
		Scanner sc = new Scanner(System.in);

//		구구단의 1 ~ 9 범위인 a , b 선언
		int a = r.nextInt(8) + 2;
		int b = r.nextInt(9) + 1;
		int sum = a * b;
		System.out.print(a + " X " + b + " = ");

//		정답 입력		
		int c = sc.nextInt();
		sc.close();

//		정답 확인
		String str;

		if (sum == c) {
			str = "정답";
		} else {
			str = "오답";
		}
		System.out.println("결과 :  " + str);
	}

}
