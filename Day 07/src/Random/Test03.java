package Random;

import java.lang.*;
import java.util.Random;

public class Test03 {

	public static void main(String[] args) {
//		랜덤값을 뽑아서 화면에 출력하시오
//		1. 주사위 1개를 던진 결과
//		2. 로또번호 1개를 추첨한 결과
//		3. 두 자리 정수 1개를 무작위 추첨한 결과
//		4. 6자리 OTP 번호 1개 추첨 결과
		
		Random a = new Random();
		
		// 주사위
		int dice = a.nextInt(6) + 1; // 0 ~ 5 범위에 + 1 보정
		System.out.println("주사위의 값 : " + dice);
		
		// 로또
		int[] lotto = new int[8]; // 인덱스 0 ~ 7
		System.out.print("로또 번호 추첨 : \t"); // 인덱스[i] 만큼 반복
		for(int i = 1; i <= 7; i++) {
			lotto[i]= a.nextInt(45) + 1; // 인덱스[i]에 0 ~ 44 범위에 + 1 보정 정수 입력
			System.out.print(lotto[i] + "\t");
		}
		
		//두 자리 정수
		int random = a.nextInt(90) + 10; // 0 ~ 89 범위에 + 10 보정
		System.out.println("\n" + "무작위 두 자리 정수 : " + random);
		
		//OTP
		int otp = a.nextInt(9000000) + 1000000; // 0 ~ 8999999 범위에 + 1000000 보정
		System.out.println("OTP : " + otp);
		
		
		

	}

}
