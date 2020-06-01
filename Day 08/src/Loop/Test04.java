package Loop;

import java.util.Random;

public class Test04 {

	public static void main(String[] args) {
//		개수(count) 세는 방법
//		> 합계를 구하는 방법과 크게 다르지 않다.

//		예제 : 주사위를 30번 던졌을 때 '1'이 나오는 횟수 측정

		Random r = new Random();
		int dice; // 주사위
		int i = 0; // 던지는 횟수
		int count = 0; // 1일 때 횟수

		while (i < 10) {
			dice = r.nextInt(6) + 1; // 주사위 돌리기
			System.out.print(dice + "\t"); // 돌릴 때 주사위의 숫자는 몇인가?

//			만약 주사위 값이 1이면
			if (dice == 1) {
//				카운트를 하나씩 올려라
				count++;
			}
//			위의 모든 일을 다 해내면 다시 던져라
			i++;
		}
		System.out.println("\n");
		System.out.println("1은 몇번 나오는가? " + count + "번");
	}

}
