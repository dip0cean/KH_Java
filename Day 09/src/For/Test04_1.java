package For;


public class Test04_1 {

	public static void main(String[] args) {
//		3 6 9 게임 시물레이션
//		1) 3 6 9 게임은 수자에 3, 6, 9가 포함되면 숫자를 말하지 않고 박수를 치는 게임
//		2) 박수는 3, 6, 9의 개수대로 칩니다.
//		3) 1 부터 99까지 3 6 9 게임을 한다고 치면 예상되는 패턴을 출력

		for (int i = 1; i < 99; i++) {
			int n = i;

			int a = n / 10;
			int b = n % 10;

			int count = 0;

			if (a == 3 || a == 6 || a == 9) {
				count++;
			}

			if (b == 3 || b == 6 || b == 9) {
				count++;
			}

			switch (count) {
			case 0:
				System.out.println(n + " > " + n);
				break;
			case 1:
				System.out.println(n + " > " + "짝");
				break;
			case 2:
				System.out.println(n + " > " + "짝짝");
				break;
			}
		}
	}
}
