package Basic;

import java.lang.*;

public class Test06 {
	public static void main(String[] args) {

// 김밥 개당 900원 / 1 + 1 행사 중 / 총 결제하는 가격은 얼마인가

		/*
		 * 내 풀이
		 * int kimbob= 900; int count = 5; int event = count - (count-2);
		 *
		 * int result = ((count / event ) + (count%event)) * kimbob ;
		 * 
		 * System.out.println("결제 금액 : " + result + " 원");
		 */

		// 강사님 풀이
		int gimbob = 900;
		int count = 10;

		int free = count / 2; // 규칙을 찾아라.
		int pay = count - free;
		int result = gimbob * pay;

		System.out.println(free);
		System.out.println(pay);
		System.out.println(result);
	}
}
