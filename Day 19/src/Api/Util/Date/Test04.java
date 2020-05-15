package Api.Util.Date;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test04 {

	public static void main(String[] args) {
//		Date 를 이용한 시간 계산
//		-	썩 좋지 않음
		Date today = new Date();
//		today.setDate(today.getDate() - 5);
		System.out.println(today);

		//	지금으로부터 5일 뒤 날짜 계산
		long t = today.getTime(); // System.currentTimeMillis() 동일 (밀리초)
		long a = t + (5 * 24 * 60 * 60 * 1000);
		Date after = new Date(a);
		Format f = new SimpleDateFormat("y-M-d");
		System.out.println(f.format(after));
	}

}
