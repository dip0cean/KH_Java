package Api.Lang.etc;

public class Test02 {
	public static void main(String[] args) {
//		System 클래스 > System 에 대한 정보를 불러온다.
//		-	표준 출력 통로 > System.out: 
//		-	표준 입력 통로 > System.in
//		-	표준 에러 통로 > System.err
//		>	다들 다른 통로이기 때문에 출력되는 시간이 다르다.		

		System.out.println("Hello World");
		System.err.println("Fuck World"); // 오류 메세지 출력 때 사용

		// 기준시(1970-01-01 00:00:00.0) 부터의 밀리초
		long time = System.currentTimeMillis();
		System.out.println(time);

		System.out.println(System.getProperties()); // 자바의 정보를 출력
		System.out.println(System.getProperty("java.runtime.version")); // 자바의 정보 중 원하는 정보를 출력 (문자열로 입력)
		System.out.println(System.getProperty("os.name")); // 운영체제 이름
		System.out.println(System.getProperty("sun.boot.library.path")); // 멀라

		System.out.println();
		if (!System.getProperty("os.name").toLowerCase().contains("win")) {
			System.err.println("윈도에서만 작동 가능합니다.");
			System.exit(0); // 프로그램 종료
		} else {
			System.out.println("현재 윈도우를 사용하고 있습니다.");
		}

		// System.exit(0); // 0 = 정상 종료, 나머지는 비정상 종료임을 시스템에 알려준다.

		System.gc();

	}
}
