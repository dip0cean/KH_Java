package Task;

import java.util.Scanner;

public class Task02 {

	public static void main(String[] args) {
//		사용자에게 국어, 영어, 수학 점수를 입력받아 총점과 평균을 계산하는 프로그램을 구현하시오.
//		평균은 소수점 2자리까지만 출력

//		Scanner 도구 선언
		Scanner sc = new Scanner(System.in);

//		double 타입 배열 선언
		double[] score = new double[3];

//		수학 점수 입력
		System.out.println("수학 점수를 입력하세요. > ");
		score[0] = sc.nextDouble();

//		국어 점수 입력		
		System.out.println("국어 점수를 입력하세요. > ");
		score[1] = sc.nextDouble();

//		영어 점수 입력		
		System.out.println("영어 점수를 입력하세요. > ");
		score[2] = sc.nextDouble();

//		평균 계산
		double sum = score[0] + score[1] + score[2];
		double avg = sum / score.length;
		double a = (double) ((int) (avg * 100)) / 100;

//		출력
		System.out.println("총합 : " + sum + "점");
		System.out.println("평균 : " + a + "점");

		sc.close();
	}

}
