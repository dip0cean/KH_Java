package Task;

import java.lang.*;

public class Task03 {

	public static void main(String[] args) {
//		1 ~ 1000까지 합계

		int i = 1;
		int sum = 0;

		while (i <= 1000) {
			sum += i;
			System.out.println("i = " + i);
			i++;
		}
		System.out.println("sum = " + sum);
	}
}
