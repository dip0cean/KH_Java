package Api.Util.Date;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test03 {
	public static void main(String[] args) {
//		다음 형식에 맞게 현재 시각을 출력
		Date a = new Date();
//		2000년 5월 15일 금요일
		Format f = new SimpleDateFormat("y년 M월 dd일 E요일");
		System.out.println(f.format(a));

//		오후 1:39
		f = new SimpleDateFormat("a h : mm");
		System.out.println(f.format(a));

//		13:39
		f = new SimpleDateFormat("HH : mm");
		System.out.println(f.format(a));

//		2020-05-15 13:39:40

		while (true) {
			Date s = new Date();
			f = new SimpleDateFormat("y-MM-dd HH:mm:ss");
			System.out.println(f.format(s));
			try {
				Thread.sleep(1000L);
			} catch (Exception e) {
			}
		}
	}
}
