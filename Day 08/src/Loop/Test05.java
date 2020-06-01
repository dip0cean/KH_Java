package Loop;

import java.util.Random;

public class Test05 {

	public static void main(String[] args) {
//		반복을 영원히 할 수 없으니까 반복에 제동을 걸어보자!
//		1) 횟수로 제한 (X번)
//		2) 시점으로 제한(언제까지)

//		주사위를 5가 나올 때까지 던지는 코드

		Random r = new Random();
		int dice;
		int count = 1;

		while (true) {

			dice = r.nextInt(6) + 1;
			System.out.println("주사위 : " + dice);

			if (dice == 5) {
				break;
			}
			count++;
		}
		System.out.println(count + " 번만에 5가 나왔다.");
	}

}
