package Task;

import java.lang.*;
import java.util.Random;

public class Task07 {

	public static void main(String[] args) {
//		어떤 게임에서 시작지점부터 종료지점까지 50칸이 있다고 가정
//		주사위를 던져서 종료지점까지 가려면 주사위를 몇 번 던져야 하는지 구하여 출력
		Random r = new Random();

		int dice;
		int sum = 0;
		int count = 0;

		while (true) {
			dice = r.nextInt(6) + 1;
			sum += dice;
			count++;
			if (sum >= 50) {
				break;
			}
		}
		System.out.println("총 " + count + "번 이동했습니다.");
	}

}
