package OOP.Static_0;

public class Cal {

	public static void main(String[] args) {
//		Robot.class 를 이용한 더하기 연산 > 객체 지향
		Robot rb = new Robot();
		rb.setA(10);
		rb.setB(20);
		rb.setC(rb.getA() + rb.getB());
		System.out.println(rb.getC());
	}

}
