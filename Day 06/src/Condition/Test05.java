package Condition;

import java.util.Scanner;

public class Test05 {

	public static void main(String[] args) {
//		홀수 짝수 판정 프로그램
		Scanner sc = new Scanner(System.in);

//		정수 입력
		System.out.println("정수를 입력하세요.");
		int n = sc.nextInt();
		sc.close();
		String str;

//		if else 문을 이용한 결과 출력
		if (n % 2 == 0) {
			str = "짝수";
		} else {
			str = "홀수";
		}

		System.out.println(str);

	}

}
