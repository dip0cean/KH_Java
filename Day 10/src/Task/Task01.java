package Task;

import java.lang.*;

public class Task01 {

	public static void main(String[] args) {
//		1) 10, 20, 30
//		2) "사과" , "딸기" , "바나나"
//		3) 1.2f , 2.3f, 3.4f

//		1번 문제
		int[] a = new int[10];
		for (int i = 0; i < 10 ; i++) {
			a[i] = (i + 1) * 10;
			System.out.println("a[" + i + "] = " + a[i]);
		}

		System.out.println();

//		2번 문제
		String[] b = new String[] { "사과", "딸기", "바나나" };
		for (int i = 0; i < 3; i++) {
			System.out.println("b[" + i + "] = " + b[i]);
		}

		System.out.println();

//		3번 문제
		float[] c = new float[] { 1.2f, 2.3f, 3.4f };

		for (int i = 0; i < 3; i++) {
			System.out.println("c[" + i + "] = " + c[i] + "f");
		}

	}

}
