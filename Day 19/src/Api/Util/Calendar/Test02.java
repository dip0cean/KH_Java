package Api.Util.Calendar;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Test02 {

	public static void main(String[] args) {
//		크리스마스가 d-day 일 경우 d - 100일은 무슨 요일인지 계산하여 출력

		Calendar dday = Calendar.getInstance();
		dday.set(2020, 11, 25);
		System.out.println(dday.get(Calendar.YEAR));
		System.out.println(dday.get(Calendar.MONTH) + 1);
		System.out.println(dday.get(Calendar.DAY_OF_MONTH));

		dday.add(Calendar.DATE, -100);
		System.out.println(dday.get(Calendar.DAY_OF_WEEK));

		Date d = dday.getTime();
		Format c = new SimpleDateFormat("y-MM-dd E요일");
		System.out.println(c.format(d));
	}
}
