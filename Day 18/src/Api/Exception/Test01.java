package Api.Exception;

import java.util.Scanner;

public class Test01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("금액 입력");
		long price = sc.nextLong();

		System.out.println("인원수 입력");
		int person = sc.nextInt();

		sc.close();

		long a = price / person;
		long b = price % person;
		System.out.println("한명당 " + a + "원");
		System.out.println("남은 돈 " + b + "원");
		
//		금액을 한글로
//		기본형 타입 범위를 넘어갔을 때
//		실수를 입력했을 때
//		인원수가 0일 때

	}
}
