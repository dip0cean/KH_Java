package Task;

import java.lang.*;
import java.util.*;

public class Task02 {

	public static void main(String[] args) {
//		주사위를 1000번 던질 계획입니다.
//		1 ~ 6까지 각각 몇번 나왔는지 알고 싶을 때, 이를 구하여 출력하시오

		Random r = new Random();
		int[] dice = new int[10]; // 주사위를 던질 횟수
		int[] count = new int[6]; // 각 주사위 번호가 몇 번 나왔는지 저장할 배열

//		주사위를 던지고 나온 값을 count에 저장
		for (int i = 0; i < dice.length; i++) {
			dice[i] = r.nextInt(count.length) + 1;

			count[dice[i]-1]++;
		}

//		카운터 배열에 저장된 각 값이 나온 횟수 출력		
		for (int i = 0; i < count.length; i++) {
			System.out.println("count[" + i + "] = 주사위 " + (i+1) + " = " + count[i]);
		}

	}

}
