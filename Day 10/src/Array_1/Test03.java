package Array_1;

import java.util.*;

public class Test03 {

	public static void main(String[] args) {
//		배열 : 변수가 줄줄이 모여 있는 것

//		예제 : 주사위 3개를 던진 결과를 출력하는 프로그램을 구현

		Random r = new Random();
		
		int[] d = new int[3];

		d[0]= r.nextInt(6) + 1;
		d[1] = r.nextInt(6) + 1;
		d[2] = r.nextInt(6) + 1;
		System.out.println(d[0] + " + " + d[1] + " + " + d[2] + " = " + (d[0] + d[1] + d[2]) );
		
//		반복문을 이용한 배열 생성
		Scanner sc = new Scanner(System.in);
		int f = sc.nextInt();
		sc.close();
		int[] e = new int[f];
		
		//	인덱스에 숫자 집어 넣기
		for(int i = 0; i < f; i++) {
			e[i] = r.nextInt(6) + 1;
		}
		//	인덱스 개수만큼 출력
		for(int i = 0; i < f; i++) {
			System.out.println((i+1) + "번째 : " + e[i]);
		}
	
	}

}
