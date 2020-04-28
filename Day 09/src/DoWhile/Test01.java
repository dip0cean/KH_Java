package DoWhile;

import java.lang.*;
import java.util.Scanner;

public class Test01 {

	public static void main(String[] args) {
//		do ~ while 문 (do문)
//		1) 선 실행, 후 검사를 수행하는 구문
//		2) 구문 양식이 어려워서 최근 잘 안쓰는 추세이다.

		Scanner sc = new Scanner(System.in);
		int score;

		do {
			System.out.println("시험 성적 입력");
			score = sc.nextInt();
			System.out.println(score);
		} while (score < 0 || score > 100); // 세미콜론 (;) 꼭 붙혀야 함.

		sc.close();

	}

}
