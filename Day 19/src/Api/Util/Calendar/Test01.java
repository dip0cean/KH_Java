package Api.Util.Calendar;

import java.util.Calendar;

public class Test01 {

	public static void main(String[] args) {
//		Calendar 클래스는 static 이니까, 생성자 생성 불가능
//		-> .getInstance() 메소드를 통해 메소드 호출

		Calendar c = Calendar.getInstance();
		System.out.println(c);

//		정보 설정 : .set(무엇을, 얼마로)
		c.set(Calendar.YEAR, 2000);
		c.set(2000, 0, 1); // 월 조심

//		정보 확인 : .get()
		int year = c.get(Calendar.YEAR);
		System.out.println(year + "년");

		int month = c.get(Calendar.MONTH) + 1;
		System.out.println(month + "월");

		int day = c.get(Calendar.DAY_OF_MONTH);
		System.out.println(day + "일");

		int hour = c.get(Calendar.HOUR_OF_DAY);
		System.out.println(hour + "시");

		int minute = c.get(Calendar.MINUTE);
		System.out.println(minute + "분");

		int second = c.get(Calendar.SECOND);
		System.out.println(second + "초");

		int week = c.get(Calendar.DAY_OF_WEEK);

		System.out.println(year + "-" + month + "-" + day);
		System.out.println(hour + ":" + minute + ":" + second);
		System.out.println(week);
	}
}
