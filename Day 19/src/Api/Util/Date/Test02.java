package Api.Util.Date;


import java.text.SimpleDateFormat;
import java.util.Date;

public class Test02 {
	public static void main(String[] args) {
//		날짜를 원하는 형식으로 출력하는 방법
		Date a = new Date();
		System.out.println(a);
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(f.format(a));

	}

}
