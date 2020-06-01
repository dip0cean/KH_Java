package Loop;

public class Test02 {

	public static void main(String[] args) {
//		영원히 할 수는 없으니가 반복에 제동을 걸어보자!
//		1. 횟수로 제한(X번)
//		2. 시점으로 제한(언제까지)

		int n = 0;

		while (n < 10) {
			System.out.println("Hello!" + n);
			n++; // n += 1; //n = n + 1;

			// 예외 처리 문장
			try {
				Thread.sleep(500);
			} catch (Exception e) {

			}

		}

	}

}
