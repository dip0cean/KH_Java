package Task;

import java.lang.*;
import java.util.Scanner;

public class Task06 {

	public static void main(String[] args) {
//		커피를 1잔 주문하면 쿠폰에 도장을 1개 찍어준다.
//		7번째 도장이 찍히면 8번째 주문한 커피 1잔을 무료 제공.
//		입력값 : 주문할 커피의 수
//		출력값 : 무료 제공 커피의 수 , 총 결제 금액

//		Scanner 도구 선언		
		Scanner sc = new Scanner(System.in);
//		커피 가격		
		int coffee = 1500;

//		총 주문한 커피
		System.out.println("몇 잔을 주문하시겠습니까? > ");
		int cup = sc.nextInt();

//		계산
		int tPrice = coffee * cup; // 할인 전 금액
		int free = (cup / 8); // 무료 커피
		int dPrice = tPrice - (free * coffee); // 할인 후 금액

//		결과값 출력
		System.out.println("무료 커피 :		" + free + "잔");
		System.out.println("할인 전 결제 금액 :	" + tPrice + "원");
		System.out.println("총 결제 금액 :	" + dPrice + "원");

		sc.close();

	}

}
