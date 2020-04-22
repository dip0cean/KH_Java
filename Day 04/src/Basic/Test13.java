package Basic;

import java.lang.*;

public class Test13 {
	public static void main(String[] args) {
		// BMI 계산기 (네이버에서 BMI 계산기 검색 후 비교)
		// 키 : 180CM / 체중 : 80KG 인 사람의 BMI 지수를 구하여 출력
		// BMI = (키(M) * 키(M)) / 체중(KG)

		int weight = 80;
		int height = 180;
		double m = height * 0.01;

		double avg = weight / (m * m);

		System.out.println(avg);
//		System.out.printf("%.2f", avg); // printf 를 사용하는 방법 > 복습할 것.

	}
}
