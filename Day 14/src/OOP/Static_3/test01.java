package OOP.Static_3;

public class test01 {
	public static void main(String[] args) {
//		1) 정적 메소드를 통해 숫자를 넣으면 제곱을 구하는 계산기		
		int a = Cal.square(11);
		System.out.println("정사각형의 넓이 : " + a);
		
//		2) 정적 메소드를 통해 반지름 길이를 넣으면 원의 넓이를 계산
		double b = Cal.circle(5);
		System.out.println("원의 넓이 : " + b);
	
//		3) 메소드를 통해 1 을 넣으면 그 만큼 반복한 주사위의 값을 출력
		int c = Cal.dice();
		System.out.println("주사위의 값 : " + c);
	}
}
