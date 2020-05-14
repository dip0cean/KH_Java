package Api.Lang.String;

public class Test03 {
	public static void main(String[] args) {
//		문자열 사용시 절대하면 안되는 행동
//		-	문자열에서 + 는 "연결"을 의미한다.
//		-	기준시 > 1970년 1월 1일 0시 0초
//		-	밀리초..?		

		String str = "";
		long start = System.currentTimeMillis(); // 시작 시간 측정
		for (int i = 0; i < 10000; i++) {
			str += "hello\n";
		}
		long finish = System.currentTimeMillis(); // 종료 시간 측정
		System.out.println(str);

		System.out.println(start);
		System.out.println(finish);
		System.out.println(finish - start);
	}
}
