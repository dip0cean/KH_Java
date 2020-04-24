package Random;

import java.lang.*;

public class Test01 {

	public static void main(String[] args) {
//		Math.random() 명령을 이용한 랜덤 추출
		double a = Math.random();
		double b = a * 10; // 0부터 시작하는 개수
		int c = (int)b;
		int d = c + 1; // 0 ~ 9 까지의 범위를 +1로 보정 
		
		System.out.println("a : " + a); // 0.xxxxxx
		System.out.println("b : " + b); // 0.xxx ~ 9.xxx
		System.out.println("c : " + c); // doube > int 강제 타입 변환 0 ~ 9
		System.out.println("d : " + d); // c 값에 +1 보정 > 1 ~ 10
		
//		한줄로 표현한다면 ?
		
		int e = (int) (Math.random() * 10) + 1; // a~c 과정을 하나로 묶으면
		System.out.println("e : " + e); 

	}

}
