package Basic;

public class Test11 {
	public static void main(String[] args) {
//		정수 전체

//		byte - 크기 1byte , 물리적인 파일을 다룰 때 사용
//		byte a = 1000; //허용 범위 초과 > 정수는 범위가 있는데, 범위를 초과하면 변수에 초기값을 저장할 수 없음
		byte a = 10;
		byte b = 127; // byte의 최대 범위
//		byte sum = a + b; byte의 허용 범위 초과
		int sum = a + b;
		byte c = (byte) 200; // 그냥 200은 int 타입이기 때문에 강제 타입 변환을 이용해 byte로 변환해야 한다.

		byte f = 10;
		byte g = 20;
		byte h = (byte) (f + g); // 강제 타입 변환

		System.out.println("byte type : " + c);
		System.out.println("byte type : " + h + "\n");
		System.out.println("byte type : " + sum + "\n");

//		shorts - 과거의 자료형
//		int - 정수의 기본형
		int x = 2100000000;
		int y = 1234567 * 1234567;
		System.out.println("int type : " + y + "\n");
		System.out.println("x : " + x);

// 		long - int 보다 더 큰 정수 자료형
		long z = 210000000L;
		long l = 1234567L * 1234567L;
		System.out.println("long type : " + z);
		System.out.println("long type : " + l);
	}
}
