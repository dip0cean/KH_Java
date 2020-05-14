package Api.Lang.etc;

public class Test01 {
	public static void main(String[] args) {
//		Math 클래스 > 수학 계산을 처리하는 클래스
//		-	생성자가 잠겨있다. (접근제한)
//		-	객체 생성 없이 static 메소드를 호출하는 방식으로 사용하도록 되어있다. > 성능 향상을 위해서

		// 상수
		System.out.println(Math.E); // 지수 상수
		System.out.println(Math.PI); // 원주율

		// 소수점 자리 올림 / 반올림 / 내림
		double a = 1.5; // 올림 : 2 / 반올림 : 2 / 내림 : 1

		System.out.println(Math.ceil(a)); // 올림
		System.out.println(Math.round(a)); // 반올림
		System.out.println(Math.floor(a)); // 내림

		// 절대차 (절대값)
		int b = 10;
		int c = 20;
		System.out.println(Math.abs(c - b));

		// 제곱연산
		System.out.println(Math.pow(2, 10));
		
		//	루트
		System.out.println(Math.sqrt(9));
		
		//
		System.out.println(Math.max(5, 10)); // 둘 중 큰거
		System.out.println(Math.min(9, 5)); // 둘 중 작은거
	}
}
