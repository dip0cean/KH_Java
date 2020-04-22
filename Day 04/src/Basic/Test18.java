package Basic;

import java.lang.*;

public class Test18 {
	public static void main(String[] args) {
//		논리 연산 - 여러 개의 논리를 계산 할 때 (ex. 범위 계산)
		int score = 100;
		
//		1) 60점 이상인가?
//		2) 100점 이하인가?
		
//		boolean pass = 60 <= score <= 100; 왜 연산하지 못하는가 -> 모든 연산은 순차적으로 진행된다.
		boolean pass = (60 <= score) && (score <= 100);
		System.out.println("합격 여부 : " + pass);
//		&& : and 연산
//		|| : or 연산
		
	}
}
