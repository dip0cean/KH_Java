package Task;

import java.lang.*;

public class Task03_1 {

	public static void main(String[] args) {
		/*
		 * 피보나치 수열 황금 비율 계산할 때 사용 처음 2자리 숫자는 무조건 1 3번째 자리부터는 앞의 두자리 숫자를 더한 결과가 해당 자리의 값
		 * 
		 * 30번째 자리의 숫자가 뭔지 구하라
		 */
		int location = 30; // 알고싶은 위치
		int a = 1;
		int b = 1;
		int c;
		for (int i = 3; i <= location; i++) { // 두번째부터 연산 (초반 1의 값들은 배체)
			c = a + b;
			a = b;
			b = c;
			System.out.println(i +"번째 c = " + c);
		}
	}
}
