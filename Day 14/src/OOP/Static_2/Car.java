package OOP.Static_2;

public class Car {

	public static void main(String[] args) {
//		Static 항목들은 객체 없이도 접근 및 변경이 가능하다.
		System.out.println(Sonata.company);
		System.out.println(Sonata.seat);

//		Dynamic 항목들은 객체 생성해야 불러올 수 있다.
		Sonata a = new Sonata();
		a.color = "크림슨 레드";
		a.price = 25000000;
		System.out.println(a.color);
		System.out.println(a.price);
		System.out.println();

		Sonata b = new Sonata();
		b.color = "오션 블루";
		b.price = 30000000;
		System.out.println(b.color);
		System.out.println(b.price);
		System.out.println();

	}

}
