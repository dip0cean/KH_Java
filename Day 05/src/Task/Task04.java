package Task;

import java.lang.*;
import java.util.Scanner;

public class Task04 {

	public static void main(String[] args) {
//		윤년 계산 프로그램
//		사용자에게 연도를 4자리 정수로 입력받아 윤년이면 true / 아니면 false 출력
//		1) 연도가 400의 배수이면 무조건 윤년.
//		2) 1번이 아닐 경우 연도가 100의 배수이면 윤년이 아니다.
//		3) 1,2번이 아닐 경우 연도가 4의 배수이면 윤년이다.

//		Scanner 도구 선언
		Scanner sc = new Scanner(System.in);

//		년도 입력 요구		
		System.out.println("년도를 입력하시오. > ");
		int year = sc.nextInt();

//		비교 연산
		boolean a = (year % 400 == 0); // 400의 배수인가
		boolean b = (year % 100 != 0); // 100의 배수가 아닌가
		boolean c = (a || b) && (year % 4 == 0); // a 와 b 둘 다 아닐 경우 4의 배수

//		결과 출력				
		System.out.println("400의 배수인가? : 		" + a);
		System.out.println("100의 배수가 아닌가? : 	" + b);
		System.out.println("두 경우 다 아니면 4의 배수인가? : 	" + c);
		System.out.println("입력한 값은 윤년인가요? :	" + c);

		sc.close();

	}

}
