package OOP.Inherit_1;

public class Test {
	public static void main(String[] args) {
//		하위 클래스 (Galaxy, iPhone, Xiaomi) 들의 객체를 생성 후 기능 사용
//		그 때 직접 다 만든 것과 상속된 것이 같은 기능을 하는가

		Galaxy a = new Galaxy();
		a.ver = "20s";
		a.num = "010-9467-6216";
		a.camera();
		a.call();
		a.sms();

		iPhone b = new iPhone();
		b.ver = "iPhone SE";
		b.num = "010-2667-1282";
		b.camera();
		b.call();
		b.sms();

		Xiaomi c = new Xiaomi();
		c.ver = "Redmi";
		c.num = "010-6672-6216";
		c.camera();
		c.call();
		c.sms();

	}
}
