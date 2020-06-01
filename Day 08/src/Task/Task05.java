package Task;

import java.util.Random;
import java.util.Scanner;

public class Task05 {

	public static void main(String[] args) {
//		이벤트에서 경품에 당첨될 확률이 2%
//		1) 30번 추첨했을 때 경품에 당첨된 횟수를 구하여 출력
//		2) 사용자에게 원하는 추첨 횟수를 입력하도록 한 뒤 당첨된 횟수를 구하여 출력

		Random r = new Random();
		Scanner sc = new Scanner(System.in);

		System.out.println("추첨 횟수를 입력해주세요.");
		int user = sc.nextInt();

		int loop = 0; 					// 추첨을 돌리기 위한 반복
		int count = 0; 					// 몇번 당첨되었는지
		int lotto; 							// 로또 번호
		sc.close();

		System.out.print("당첨 번호 > ");
		while (loop < user) {
			lotto = r.nextInt(user) + 1;
			System.out.print(lotto + "\t");

			if (lotto <= 2) {
				count++;
			}
			loop++;
		}
		System.out.println("\n"+ "총 당첨 횟수는 " + count + " 번 입니다.");
	}

}
