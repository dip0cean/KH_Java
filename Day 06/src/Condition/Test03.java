package Condition;

import java.util.Scanner;

public class Test03 {

	public static void main(String[] args) {
//		한 과목 시험 2번( 서술형, 실습형
//		1) 두 과목의 평균이 60 이상이면 통과
//		2) 한 과목이라도 40점 미만이라면 재평가
//		3) 두 과목의 평균이 60점 미만이어도 재평가

		Scanner sc = new Scanner(System.in);
//		첫 번재 시험 점수 입력
		System.out.println("첫 번째 시험 점수");
		int score1 = sc.nextInt();
		
//		두 번째 시험 점수 입력		
		System.out.println("두 번째 시험 점수");
		int score2 = sc.nextInt();
		
		sc.close();
//		시험 점수 조건 비교 연산
		double avg = (double)(score1 + score2) / 2;
		boolean a = 60 <=  avg && 100 >= avg; // 합격 기준 : 평균 60점 이상
		boolean b = (40 <= score1 && 100 >= score1) && (40 <= score2 && 100 >= score2); // 합격 기준 : 두 점수 40점 이상

		System.out.println("두 과목 평균이 60점 이상인가? " + a);
		System.out.println("한 과목 40점 이상인가? " + b);

//		출력
		if (a && b) {
			System.out.println("합격입니다.");
		} 

		if (!a || !b) {
			System.out.println("불합격입니다.");
		}

	}

}
