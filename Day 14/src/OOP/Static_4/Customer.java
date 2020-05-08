package OOP.Static_4;

public class Customer {

	public static void main(String[] args) {
//		기본 이율은 모든 가입자에게 동일하게 적용된다.
//		우대 이율은 가입자마다 다르게 적용된다.
//		예금액은 음수로 설정할 수 없다.

		SafeBox a = new SafeBox("손오공", 0.5, 1000000);
		SafeBox b = new SafeBox("베지터" , 0.2, 1500000);
		SafeBox c = new SafeBox("부르마" , 0.5, 2000000);
		
		a.output();
		b.output();
		c.output();
		
	}

}
