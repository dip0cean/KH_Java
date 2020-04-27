package Task;

import java.lang.*;
import java.util.Random;

public class Task02 {

	public static void main(String[] args) {
//		주사위 5번 던진 결과를 화면에 출력하세요.

		Random r = new Random();

		int i = 0;
		int dice;

		while (i < 5) {
			i++;
			dice = r.nextInt(6) + 1;
			System.out.println(i + " 번째 주사위의 값 : " + dice);
		}

	}

}
