package Api.Lang.String;

public class Test05 {
	public static void main(String[] args) {
		
		StringBuffer sb = new StringBuffer();	//	Thread-Safe
		long start = System.currentTimeMillis(); // 시작 시간 측정
		for (int i = 0; i < 20000; i++) {
			sb.append("hello\n");
		}
		long finish = System.currentTimeMillis(); // 종료 시간 측정
		System.out.println(sb.toString());

		System.out.println(start);
		System.out.println(finish);
		System.out.println(finish - start);
	}
}
