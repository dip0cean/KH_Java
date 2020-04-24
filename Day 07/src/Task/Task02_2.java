package Task;

import java.util.Random;

public class Task02_2 {

	public static void main(String[] args) {
//		이벤트 경품 행사를 진행중입니다.
//		총 1000명을 대상으로 추첨을 진행하며, 경품 내역은 다음과 같습니다.
		/*
		 * 1등( 1 명) : 최고급 세단 / 2등 ( 3 명) : 최고급 컴퓨터 / 3등 ( 10 명) : 태블릿 PC / 4등 (나머지) : 꽝
		 */
//		실행하면 1회 추첨 결과가 나오도록 프로그램을 구현.

		Random r = new Random();
		String win;

		int me = r.nextInt(1000) + 1;
		System.out.println("나 : \t\t" + me);
		
		if(me == 1) {
			win = "1등";
		} else if(1 < me && 5 > me) {
			win = "2등";
		} else if(6 < me && 17 > me) {
			win = "3등";
		} else {
			win = "꽝";
		}
		
		System.out.println("당첨 결과 : \t" + win);

	}

}
