package Task;

import java.util.Random;
import java.util.Scanner;

public class Task01 {

	public static void main(String[] args) {
//		영원히 실행되는 구구단 문제 풀기 프로그램을 구현
		Random r = new Random();
		Scanner sc = new Scanner(System.in);

		int a, b, c;

		while (true) {
			a = r.nextInt(8) + 2;
			b = r.nextInt(9) + 1;
			System.out.print(a + " X " + b + " = ");

			c = sc.nextInt();
			if (c == (a * b)) {
				System.out.println("정답입니다.");
			} else {
				System.out.println("오답입니다.");
			}

		}

	}

}
