package Random;

import java.lang.*;
import java.util.Random;

public class Test02 {

	public static void main(String[] args) {
//		Random 도구를 사용하여 랜덤값 추출
		
//		Random 도구 선언		
		Random a = new Random();
		
		int b = a.nextInt();	// Random 클래스의 a 라는 객체에서 int 타입 값을 불러와라.
		int c = a.nextInt(10);	// Random 클래스의 a 라는 객체에서 10 만큼의 int 타입 값을 불러와라.
		System.out.println("b : " + b);
		System.out.println("c : " + c);
		

	}

}
