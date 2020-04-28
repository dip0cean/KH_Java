package For;

import java.lang.*;

public class Test05_1 {

	public static void main(String[] args) {
//		소수 찾기 프로그램
//		- 소수는 나누기 불능인 숫자를 말한다.
//			- 1 또는 자기 자신으로만 나누어 떨어지는 숫자를 말한다.
//			- 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 
//		- 합성수는 나누기 가능인 숫자를 말한다.
//			- 1과 자기 자신 외에도 나누어 떨어지는 숫자가 있는 경우를 말한다.
//			- 4, 6, 8, 9, 10, 12, 14, 15, 16, 18, 20, 21, 22, 24, 25, 26, 27, 28, 30
//		- 1은 어떠한 분류에도 포함되지 않는다.

//		> 사용자가 입력한 숫자가 "소수" 인지 "합성수" 인지 판정하는 프로그램을 구현

		int count;
		int avg;
		for (int i = 1; i <= 1000; i++) {
			count = 0;
			for (int k = 1; k <= i; k++) {
				avg = i % k;
				if (avg == 0) {
					count++;
				}
			}
			if (i == 1) {
				System.out.println(i + "\t > 분류되지 않음.");
			} else if (count == 2 && i > 1) {
				System.out.println(i + "\t > 소수");
			} else {
				System.out.println(i + "\t > 합성수");
			}
		}
	}
}
