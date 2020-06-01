package Task;


public class Task01 {

	public static void main(String[] args) {
//		for 문을 이요해서 다음 데이터를 출력하시오.
//		1) 1 ~ 100 정수		
//		2) 1 ~ 100 홀수
//		3) 1 ~ 100 3의 배수
//		4) 모든 대문자 알파벳
//		5) 모든 한글

//		1) 1 ~ 100 정수

		for (int i = 1; i <= 100; i++) {
			System.out.println("i = " + i);
		}

		System.out.println();

//		2) 1 ~ 100 홀수
		for (int i = 1; i <= 100; i++) {
			int odd = i % 2;
			if (odd != 0) {
				System.out.println("i의 홀수 = " + i);
			}
		}

		System.out.println();

//		3) 1 ~ 100 3의 배수
		for (int i = 1; i <= 100; i++) {
			int three = i % 3;
			if (three == 0) {
				System.out.println("i의 3의 배수 = " + i);
			}
		}

		System.out.println();

//		4) 모든 대문자 알파벳
		int count1 = 1;
		System.out.println("char Type eng = ");
		for (char i = 'A'; i <= 'Z'; i++) {
			System.out.print("\t" + i);
			if (count1 % 5 == 0) {
				System.out.println();
			}
			count1++;
		}

		System.out.println("\n");

//		5) 모든 한글
		int count = 1;
		System.out.println("모든 한글 = ");
		for (char i = '가'; i <= '힇'; i++) {
			System.out.print(i);
				if (count % 10 == 0) {
					System.out.println();
				}
			count++;
		}

	}

}
