package OOP.Static_1;

public class Cal {

	public static void main(String[] args) {
//		Robot 을 이용하여 10 + 20을 계산
//		-	Robot 안에 정적 메소드로 plus 를 만들어 놓음.		

		int v = Robot.plus(10, 20);
		System.out.println(v);

	}

}
