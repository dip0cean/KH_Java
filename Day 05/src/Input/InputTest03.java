package Input;

import java.util.*;

public class InputTest03 {

	public static void main(String[] args) {
//		실수 입력 받기

//		Scanner 도구 생성
		Scanner sc = new Scanner(System.in);

//		안내문 출력
		System.out.println("키와 몸무게를 입력하세요. > ");

//		double / float 타입 실수 입력	
		double a = sc.nextDouble();
		float b = sc.nextFloat();

//		입력한 데이터 출력
		System.out.println("키 : " + a + "cm 입니다.");
		System.out.println("몸무게 : " + b + "kg 입니다.");

//		Scanner 도구 종료
		sc.close();

	}

}
