package Task;

import java.lang.*;
import java.util.Scanner;

public class Task02 {

	public static void main(String[] args) {
//		사용자에게 숫자를 하나 입력 받아서 다음을 검사하려고 한다.
//		1) 2의 배수
//		2) 3의 배수
//		3) 2와 3의 배수
//		가능한 모든 경우를 파악하여 조건을 이용한 판정 결과를 화면에 출력하시오.

		Scanner sc = new Scanner(System.in);

//		정수 입력		
		System.out.println("숫자를 입력하세요.");
		int a = sc.nextInt();
		sc.close();

//		문자열 변수 선언		
		String str;

//		조건문		
		if ((a % 2 == 0) && (a % 3 == 0)) {
			str = "2와 3의 배수다.";
		} else if (a % 2 == 0) {
			str = "2의 배수다.";
		} else if (a % 3 == 0) {
			str = "3의 배수다.";
		} else {
			str = "2의 배수도 3의 배수도 아니다.";
		}

//		결과 출력		
		System.out.println("입력값 : " + a);
		System.out.println(a + " 은(는) " + str);
	}

}
