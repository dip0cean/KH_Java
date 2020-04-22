package Output;

import java.lang.*;

public class OutputTest01 {

	public static void main(String[] args) {
//		System.out 을 이용한 출력
		System.out.print("안");
		System.out.print("녕");
		System.out.print(" 반갑습니다.");
		System.out.println("잘부탁드려요.");

//		문자열과 기본 타입을 함께 사용
		int age = 20;
		System.out.println("현재 나이는 " + age + "세 입니다.");
		System.out.println("10년 뒤 나이는 " + (age + 10) + "세 입니다.");

//		printf() 메소드
		System.out.printf("이름 : %s", "심성헌");

	}

}
