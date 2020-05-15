package Api.Util.Calendar;

import java.util.Calendar;

public class Test03 {

	public static void main(String[] args) {
//		준비
		int year = 2020;
		int month = 5;

//		계산
//		1. 처음 출력되어야 하는 날짜
//		- year 년 month 월 1일의 요일을 구하여 전달을 몇개 출력하는 계산
		Calendar c = Calendar.getInstance();
		// 설정한 날짜
		c.set(year, month - 1, 1);
		// 설정한 날짜의 요일
		int week = c.get(Calendar.DAY_OF_WEEK);
		System.out.println(week);
		// 1일 이전의 날짜들
		int minus = week - 1;
		c.add(Calendar.DATE, -minus);
		
		System.out.println(c.getTime());
		
//		2. 계산된 날짜부터 42번(7번씩 6줄) 출력
		for(int i = 0; i < 42; i++) {
			System.out.print(c.get(Calendar.DATE) + "\t");
			c.add(Calendar.DATE, +1);
			if(i % 7 == 6) {
				System.out.println("\n");
			}
		}

	}
}
