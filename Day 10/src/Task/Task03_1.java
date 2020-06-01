package Task;

import java.util.*;

public class Task03_1 {

	public static void main(String[] args) {
//		사용자에게 10개의 숫자를 입력받아서 "짝수"와 "홀수"를 각각 구분하여 출력
//		짝수합, 홀수합도 각각 따로 구해서 출력

		Scanner sc = new Scanner(System.in);

		System.out.println("정수 10개를 입력해주세요.");
		int[] user = new int[10];
		int[] count = new int[user.length];

//		인덱스에 정수 입력		
		for (int i = 0; i < user.length; i++) {
			System.out.print((i + 1) + " 번째 정수 > ");
			user[i] = sc.nextInt();
			
//			인덱스에 저장된 입력값의 짝수 / 홀수 비교
			for (int k = 0; k < user.length; k++) {
				count[k] = 0;
				if (user[k] % 2 == 0) {
					count[k]++;
				}
			}
		}

		sc.close();
		System.out.println();
		
//		짝수의 수 / 홀수의 수		
		System.out.println("짝수의 수 > ");
		for(int i = 0; i < user.length; i++) {
			if(count[i] == 1) {
				System.out.print(user[i] + "\t");
			}
		}
		System.out.println("\n");
		
		System.out.println("홀수의 수 > ");
		for(int i = 0; i < user.length; i++) {
			if(count[i] == 0) {
				System.out.print(user[i] + "\t");
			}
		}
		System.out.println("\n");
		
//		짝수합 / 홀수합
		int[] sum = new int[2];
		for (int i = 0; i < user.length; i++) {
			if (count[i] == 1) {
				sum[0] += user[i];
			} else {
				sum[1] += user[i];
			}
		}
		System.out.println("짝수의 합 : " + sum[0]);
		System.out.println("홀수의 합 : " + sum[1]);
	}

}
