package Api.Util.Random;

import java.util.Random;

public class Test02 {
	public static void main(String[] args) {
//		OTP 만들어보기!
		long time = System.currentTimeMillis(); // 밀리초 -> 1초는 1천 밀리초 / 10초는 1만 밀리초
		System.out.println(time / 72000);

		String id1 = "test1234";
		String id2 = "master1234";

		Random r = new Random();
		r.setSeed(time / 72000 + id1.hashCode());
		r.nextInt();
		r.nextInt();
		r.nextInt();
		System.out.println(r.nextInt(1000000));

		r.setSeed(time / 72000 + id2.hashCode());
		System.out.println(r.nextInt(1000000));
	}
}
