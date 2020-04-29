package Array;

import java.lang.*;
import java.util.*;

public class Test02 {

	public static void main(String[] args) {
//		배열 : 변수가 줄줄이 모여 있는 것

//		예제 : 주사위 3개를 던진 결과를 출력하는 프로그램을 구현

		Random r = new Random();
		
		int[] d = new int[3];

		d[0]= r.nextInt(6) + 1;
		d[1] = r.nextInt(6) + 1;
		d[2] = r.nextInt(6) + 1;
		System.out.println(d[0] + " + " + d[1] + " + " + d[2] + " = " + (d[0] + d[1] + d[2]) );
		
//		배열 생성 : 여러개라고 생각하지만 실제로는 n 개
//		n개의 변수를 합쳐서 사용
		
		int x = 3;
		int[] y = new int[x];
		for(int i = 0; i < x; i++) {
			y[i] = r.nextInt(6) + 1;
			System.out.println((i + 1) + "번째 : " + y[i]);
		}
	
	}

}
