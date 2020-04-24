package Random;

import java.lang.*;
import java.util.Random;

public class Test06 {

	public static void main(String[] args) {
//		랜덤으로 카드 한장이 출력되도록 코드를 구현
//		- 모양 : 하트 / 다이아 / 클로버 / 스페이드
//		- 숫자 : A / 2 / 3 / 4 / 5 / 6 / 7 / 8 / 9 / 10 / J / Q / K

		Random r = new Random();

		// 카드의 모양
		int a = r.nextInt(4);
		String cardA;
		
		if (a == 0) {
			cardA = "하트";
		} else if (a == 1) {
			cardA = "다이아";
		} else if (a == 2) {
			cardA = "클로버";
		} else {
			cardA = "스페이드";
		}
		
		// 카드의 숫자
		int b = r.nextInt(13) + 1;
		String cardB;
		if(b == 1) {
			cardB = "A";
		} else if(b == 11) {
			cardB = "J";
		} else if(b == 12) {
			cardB = "Q";
		} else if(b == 13) {
			cardB = "K";
		} else {
			cardB = "" + b;
		}
		System.out.println(cardA + " " + cardB);
	}
}
