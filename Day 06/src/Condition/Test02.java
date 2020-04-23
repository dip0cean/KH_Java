package Condition;

import java.lang.*;
import java.util.Scanner;

public class Test02 {

	public static void main(String[] args) {
// 		입력받은 시험 점수가 불합격 < 60 <= 합격.
//		Scanner 도구 선언
		Scanner sc = new Scanner(System.in);

//		점수 입력
		System.out.println("시험 점수를 입력해주세요.");
		int score = sc.nextInt();
		sc.close();

		boolean pass = 60 <= score && 100 >= score; // 기준 점수와 입력 점수 비교 연산

//		60점 이상이면 합격		
		if (pass) {
			System.out.println("합격입니다. 추카추카~^ 0^");
		}

//		60점 미만이면 불합격		
		if (!pass) {
			System.out.println("불합격입니다. 재평가를 보세용~ ㅠ 0ㅠ");
		}

	}

}
