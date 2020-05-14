package Api.Exception;

import java.util.Scanner;

public class Test05 {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
//		price 나 person 은 음수가 되면 안됨
//		-	JVM 이 인지할 수 있도록 알려준다.
//		-	문제 상황이 감지하여 Catch 블록으로 throw 시킨다.		
		Scanner sc = new Scanner(System.in);
		try {

			System.out.println("금액 입력");
			long price = sc.nextLong();
			if (price < 0) {
				// throw 예외 객체
				throw new Exception("음수를 입력하셨습니다.");
			}

			System.out.println("인원수 입력");
			int person = sc.nextInt();
			if (person < 0) {
				throw new Exception();
			}

			sc.close();

			long a = price / person;
			long b = price % person;
			System.out.println("한명당 " + a + "원");
			System.out.println("남은 돈 " + b + "원");

		} catch (Exception e) {
//			System.err.println(e);	//	예외객체
			if (e.getMessage() == null) {
				System.err.println("오류 발생");
			} else {
				System.err.println(e.getMessage());
			}
			// e.printStackTrace(); // 원인 메세지 출력
		}
		// > 오류 메세지를 해결 했지만 문제 해결이 어려워짐
//		금액을 한글로
//		기본형 타입 범위를 넘어갔을 때
//		실수를 입력했을 때
//		인원수가 0일 때

	}
}
