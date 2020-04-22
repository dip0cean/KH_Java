package Task;

import java.lang.*;
import java.util.Calendar;

public class Task02 {

	public static void main(String[] args) {
//		20010715 라는 생년월일 값이 정수로 주어졌다.
//		해당하는 사람이 성인이라면 true / 미성년자라면 false를 출력
//		단, 대한민국 성인은 20세 이상이다.

//		입력
		int birthYear = 19950715 / 10000; // 태어난 년도만 빼오는 계산
		int thisYear = Calendar.getInstance().get(Calendar.YEAR); // 현재 년도

//		계산
		int age = (thisYear - birthYear) + 1; // 현재 한국식 나이

//		결과		
		boolean adult = age > 19; // 이 나이는 19세 이상이라 성인인가 맞으면 true 틀리면 false
		System.out.println("현재 나이 : " + age + " 세");
		System.out.println("성인인가? : " + adult);

	}

}
