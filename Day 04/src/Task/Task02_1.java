package Task;

import java.lang.*;

public class Task02_1 {

	public static void main(String[] args) {
//		강사님 풀이

//		준비 : 생년월일 8자리 정수		
		int birth = 20010715;

//		계산 : 생년 4자리 , 나이를 통해 성인인지 미성년인지 출력해라
		int year = birth / 10000;
		int age = 2020 - year + 1;

//		결과		
		boolean adult = age >= 20;
		System.out.println(adult);

	}

}
