package Task;

import java.lang.*;
import java.util.Scanner;

public class Task03_2 {

	public static void main(String[] args) {

//		입력 부분 > 사용자에게 숫자 10개를 입력받아 배열에 저장
		Scanner sc = new Scanner(System.in);
		System.out.println("정수 10개를 입력하세요.");
		int[] data = new int[10];

		for (int i = 0; i < data.length; i++) {
			data[i] = sc.nextInt();
		}
		sc.close();

//		계산 > 홀수합(odd) / 짝수합(even)
		int oddTotal = 0; // 홀수합
		int evenTotal = 0; // 짝수합

		for (int i = 0; i < data.length; i++) {
			if (data[i] % 2 == 0) {
				evenTotal += data[i];
			} else {
				oddTotal += data[i];
			}
		}
//		출력 부분 >
		System.out.println();
		System.out.println("짝수합 : " + evenTotal);
		System.out.println("홀수합 : " + oddTotal);
		
		System.out.println();
		for(int i = 0; i < data.length; i++) {
			if(data[i] % 2 != 0) {
				System.out.println("홀수 : " + data[i]);				
			}
		}
		System.out.println();
		for(int i = 0; i < data.length; i++) {
			if(data[i] %2 == 0) {
				System.out.println("짝수 : " + data[i]);				
			}
		}
	}

}
