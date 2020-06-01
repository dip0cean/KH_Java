package Condition;

import java.util.Scanner;

public class Test01 {

	public static void main(String[] args) {
//		n이라는 데이터가 홀수인지 짝수인지 판정하여 출력
//		true / false 가 아닌 글자를 출력해서 판정 결과를 알려주려고 함

//		Scanner 도구 선언		
		Scanner sc = new Scanner(System.in);

//		정수 입력
		System.out.println("숫자를 입력해주세요.");
		int n = sc.nextInt();
		sc.close();

//		만약(if) 짝수라면
		if (n % 2 == 0) {

			System.out.println("입력하신 값은 짝수 입니다.");

		}

//		만약(if) 홀수라면		
		if (n % 2 != 0) {

			System.out.println("입력하신 값은 홀수 입니다.");

		}
		
	}

}
