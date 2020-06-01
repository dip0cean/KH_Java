package Task;

import java.util.Random;

public class Task02_1 {

	public static void main(String[] args) {
//		이벤트 경품 행사를 진행중입니다.
//		총 1000명을 대상으로 추첨을 진행하며, 경품 내역은 다음과 같습니다.
		/*
		 * 1등( 1 명) : 최고급 세단 / 2등 ( ? 명) : 최고급 컴퓨터 / 3등 ( ? 명) : 태블릿 PC / 4등 ( ? 명) : 꽝
		 */
//		실행하면 1회 추첨 결과가 나오도록 프로그램을 구현.

		Random r = new Random();
		String win;

		int me = r.nextInt(1000) + 1;
		System.out.println("나 : \t" + me);

//		1등
		int first = r.nextInt(1000) + 1;
		boolean winFirst = me == first;
		
//		2등
		int second1 = r.nextInt(1000) + 1;
		int second2 = r.nextInt(1000) + 1;
		int second3 = r.nextInt(1000) + 1;
		boolean winSecond = me == second1 || me == second2 || me == second3;
		
//		3등
		int third1 = r.nextInt(1000) + 1;
		int third2 = r.nextInt(1000) + 1;
		int third3 = r.nextInt(1000) + 1;
		int third4 = r.nextInt(1000) + 1;
		int third5 = r.nextInt(1000) + 1;
		int third6 = r.nextInt(1000) + 1;
		int third7 = r.nextInt(1000) + 1;
		int third8 = r.nextInt(1000) + 1;
		int third9 = r.nextInt(1000) + 1;
		int third10 = r.nextInt(1000) + 1;
		boolean winThird = 
				me == third1 || me == third2 || me == third3 || me == third4 || me == third5 || me == third6 || me == third7 || me == third8 || me == third9 || me == third10;
		
		if(winFirst) {
			win = "1등";
		} else if(winSecond) {
			win = "2등";
		} else if(winThird) {
			win = "3등"; 
		} else {
			win = "꽝";
		}
		System.out.println(win);
	}

}
