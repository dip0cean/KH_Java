package Random;

import java.util.Random;

public class Test04 {

	public static void main(String[] args) {
//		1) 동전 1개를 던져서 나온 결과 - "앞" 또는 "뒤"
//		2) 가위바위보 중 한개 추첨
//		3) 윷놀이 1턴 결과 (빽도 , 도 , 개 , 걸 , 윷 , 모)
//			윷놀이에서는 각각의 값들이 나올 확률이 다르다.

		Random r = new Random();

		// 동전
		int coin = r.nextInt(2);
		String or;

		if (coin == 1) {
			or = "앞면";
		} else {
			or = "뒷면";
		}
		System.out.println("동전의 " + or + "\n");

		// 가위바위보
		int rsp = r.nextInt(3);
		String start;

		if (rsp == 0) {
			start = "가위";
		} else if (rsp == 1) {
			start = "바위";
		} else {
			start = "보";
		}
		System.out.println("안내면 진거 가위바위보! " + start + "\n");

		// 윷놀이
		// 1 = 앞면 / 0 = 뒷면
		int game1 = r.nextInt(2);
		int game2 = r.nextInt(2);
		int game3 = r.nextInt(2);
		int game4 = r.nextInt(2);

		int sum = game1 + game2 + game3 + game4;
		String a;

		if (sum == 0) {
			a = "모";
		} else if (sum == 1) {
			if (game1 == 1) {
				a = "빽도";
			} else {
				a = "도";
			}
		} else if (sum == 2) {
			a = "개";
		} else if (sum == 3) {
			a = "걸";
		} else {
			a = "윷";
		}

		System.out.println("" + game1 + " " + game2 + " " + game3 + " " + game4);
		System.out.println("윷놀이 결과 : " + a);

	}

}
