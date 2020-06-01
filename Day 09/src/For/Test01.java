package For;


public class Test01 {
	public static void main(String[] args) {
//		목표 1부터 10까지를 화면에 출력
		int n = 1; // 선언부 : 반복에 필요한 숫자를 선언하고 초기화하는 부분

//		 while 문
		while (n <= 10) { // 조건부 : 반복을 수행하기 위해 필요한 조건을 검사
			System.out.println("n = " + n);

			n++; // 증감부 : 반복수를 증가 또는 감소시키는 부분
		}

//		for 문
		for (int i = 0; i <= 10; i++) {
			System.out.println("i = " + i);
		}

	}
}
