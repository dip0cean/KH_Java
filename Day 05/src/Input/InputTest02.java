package Input;

import java.util.*;

public class InputTest02 {

	public static void main(String[] args) {
//		Scanner 라는 도구를 사용하여 사용자에게 입력받는 코드
//		- 글자를 모아서 입력 받아준다.
//		- 자료형을 원하는 형태로 입력받을 수 있다.

//		Scanner 를 사용하려면 어떻게 해야 하는가?
		Scanner sc = new Scanner(System.in); // Scanner 생성 명령

//		정수		
		int a = sc.nextInt();

//		실수
		double b = sc.nextDouble();

		System.out.println("정수 입력값 : " + a);
		System.out.println("실수 입력값 : " + b);

		sc.close(); // Scanner 종료 명령
	}

}
