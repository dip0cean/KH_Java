package For;

import java.lang.*;
import java.util.*;

public class Test03 {

	public static void main(String[] args) throws InterruptedException {
//		1) 분과 초가 있는 타이머를 구현
//		2) 분과 초를 사용자가 입력해서 설정
//		3) 해당 시간만큼의 메세지가 화면에 출력되고 그 뒤에 알림 메세지 출력

		Scanner sc = new Scanner(System.in);

		System.out.println("타이머를 설정하세요.");
		int minute = sc.nextInt();
		int second = sc.nextInt();
		sc.close();
		int sTime = (minute * 60) + second;

		for (int i = sTime; i > 0; i--) {
			int m = (i / 60);
			int s = (i % 60);
			System.out.println("남은 시간 : " + m + "분 " + s + "초");

			if (i == 0) {
				System.out.println("타이머가 종료되었습니다.");
				break;
			}
			Thread.sleep(1000L);
		}

	}

}
