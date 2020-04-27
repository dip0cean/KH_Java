package Loop;

import java.lang.*;
import java.util.Random;

public class Test03 {

	public static void main(String[] args) {
//		주사위를 10번 던지는 코드

		Random r = new Random();
		
		int i = 0;
		int sum = 0;
		double avg;

		while (i < 10) {
//			주사위 10번 돌리기
			i++;
			int dice = r.nextInt(6) + 1;
			System.out.println(i + " 번째 주사위는 " + dice + " 입니다.");
			
//			모든 값의 합계
			sum += dice;
			System.out.println( i + " 번째까지 나온 주사위 값의 합계는 " + sum + " 입니다. \n");
			
		}
//		합계의 평균
		avg = sum / 10.0;
		System.out.println("합계 : " + sum);
		System.out.println("평균 : " + avg);
		
	}

}
