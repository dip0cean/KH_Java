package Array;

import java.lang.*;

public class Test04 {

	public static void main(String[] args) {
//		배열에 내장되어 있는 값
		int[] data = new int[] { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100 };
		for (int i = 0; i < data.length; i++) {
			System.out.println("data[" + i + "] : " + data[i]);
		}
		System.out.println("data 배열의 길이 : " + data.length);

		System.out.println();

//		배열 전체를 반복하기 위한 반복문의 양식
		int[] data2 = new int[3];
		System.out.println("data2 배열의 길이 : " + data2.length);
		for (int i = 0; i < data2.length; i++) {
			data2[i] = i + 1;
			System.out.println("data2[" + i + "] : " + data2[i]);
		}
		System.out.println();
		int var = 10;
		int[] data3 = new int[var];
		for (int i = 0; i < var; i++) {
			data3[i] = (i + 1) * 15;
			System.out.println("data[" + i + "] : " + data3[i]);
		}

	}

}
