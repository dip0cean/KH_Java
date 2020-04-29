package Task;

import java.lang.*;
import java.util.Scanner;

public class Task04 {

	public static void main(String[] args) {
//		시험 점수 관리 프로그램

//		1) 우리반 학생들의 시험 성적 평균
//		2) 90점을 맞은 학생의 예상 등수를 구하여 출력(사용자가 입력해도 괜찮다.)

//		입력		
		int[] score = new int[] { 70, 85, 92, 66, 72, 88, 92, 70, 81, 93 };
		int sum = 0;
		for (int i = 0; i < score.length; i++) {
			sum += score[i];
		}

//		계산
		double avg = sum / (double) score.length;

//		점수 출력
		System.out.println("점수 합계 : " + sum + "점"); // 합계
		System.out.println("점수 평균 : " + avg + "점"); // 평균

//		내 점수 입력
		Scanner sc = new Scanner(System.in);
		System.out.print("\n나의 점수를 입력하세요. > ");
		int myScore = sc.nextInt();
		sc.close();

//		등수 확인 > 공동 등수는 상관 없이 "내 점수"가 전체에서 몇등인지가 중요. > 내 위에 몇명이 있는지가 중요하다.
		int count = 0;
		for (int i = 0; i < score.length; i++) {
			if (myScore < score[i]) {
				count++;
			}
		}
		System.out.println("나의 등수는 " + (count + 1) + "등 입니다.");
	}
}
