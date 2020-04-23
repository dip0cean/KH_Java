package Condition;

import java.lang.*;
import java.util.Scanner;

public class Test06 {

	public static void main(String[] args) {
//		Test04 문제를 조건 그룹으로 개조
		Scanner sc = new Scanner(System.in);
		
//		월 입력		
		System.out.println("날짜를 입력해주세요. > ");
		int month = sc.nextInt();
		sc.close();

//		입력된 수를 통해 계절 확인
		String season;
		int discount;

		if (month / 3 == 1) {
			season = "봄";
			discount = 20;
		} else if (month / 3 == 2) {
			season = "여름";
			discount = 0;
		} else if (month / 3 == 3) {
			season = "가을";
			discount = 5;
		} else {
			season = "겨울";
			discount = 30;
		}
		
//		계절과 할인율 출력
		System.out.println(season + " 여행을 예약하시면 " + discount + " % 할인됩니다.");

	}

}
