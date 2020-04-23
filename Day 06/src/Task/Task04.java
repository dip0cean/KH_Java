package Task;

import java.util.Scanner;

public class Task04 {

	public static void main(String[] args) {
//		성적 등급 계산 프로그램
//		사용자에게 파이썬, 자바 시험의 점수를 입력받아 등급을 계산하여 출력
//		등급은 평균으로 계산

		Scanner sc = new Scanner(System.in);
		
		System.out.println("파이썬 점수를 입력하세요.");
		double pythonScore = sc.nextDouble();
		System.out.println("자바 점수를 입력하세요.");
		double javaScore = sc.nextDouble();
		sc.close();

		double avg =(double)((int)(((pythonScore + javaScore) / 2)*100))/100;

		String grad;

		boolean A = 90.0 <= avg && 100.0 >= avg;
		boolean B = 80.0 <= avg && 90.0 > avg;
		boolean C = 70.0 <= avg && 80.0 > avg;
		boolean D = 60.0 <= avg && 70.0 > avg;

		if (A) {
			grad = "A등급";
		} else if (B) {
			grad = "B등급";
		} else if (C) {
			grad = "C등급";
		} else if (D) {
			grad = "D등급";
		} else {
			grad = "F등급";
		}
		System.out.println("귀하의 평균 점수는 "  + avg + "점이며"+ grad + "입니다.");
	}

}
