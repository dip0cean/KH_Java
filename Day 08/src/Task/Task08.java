package Task;

import java.lang.*;
import java.util.*;

public class Task08 {

	public static void main(String[] args) {
//		컴퓨터가 1 ~ 1000 까지 무작위 숫자를 하나 생성한 뒤 사용자가 이것을 맞추는 게임
//		1) 사용자가 입력한 값이 정답보다 작으면 컴퓨터는 "Up!" 이라고 출력
//		2) 사용자가 입력한 값이 정답보다 크면 컴퓨터는 "Down!" 이라고 출력
//		3) 사용자가 입력한 값이 정답이라면 컴퓨터는 "정답!" 출력 후 프로그램 종료
//		4) 프로그램이 종료되기 전(정답을 맞춘 뒤) 총 입력 횟수를 출력

		Random r = new Random();
		Scanner sc = new Scanner(System.in);

		int computer = r.nextInt(1000) + 1;
		System.out.println("컴퓨터의 랜덤 숫자 > " + computer);

		int answer;
		int count = 0;
		String str;

		while (true) {
			System.out.println("정답을 입력해주세요.");
			answer = sc.nextInt();
			count++;
				if (answer < computer) {
					str = "Up!";
				} else if (answer > computer) {
					str = "Down!";
				} else {
					str = "정답입니다!";
					break;
				}
				
			System.out.print(str + " > ");
		}
		sc.close();
		System.out.println(str);
		System.out.println("횟수 : " + count + "번 입력했습니다.");

	}

}
