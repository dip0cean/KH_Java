package OOP.v3.r0;

public class Cafe {

	public static void main(String[] args) {
		Cafe_Menu a = new Cafe_Menu();
		Cafe_Menu b = new Cafe_Menu();
		Cafe_Menu c = new Cafe_Menu();
		Cafe_Menu d = new Cafe_Menu();

		a.menu = "아메리카노";
		a.type = "음료";
		a.price = 1800;
		a.sale = true;

		b.menu = "프라푸치노";
		b.type = "음료";
		b.price = 3500;
		b.sale = false;

		c.menu = "파니니";
		c.type = "식사";
		c.price = 2800;
		c.sale = true;

		d.menu = "크로크무슈";
		d.type = "식사";
		d.price = 3300;
		d.sale = false;

		System.out.print(a.menu + "\t");
		System.out.print(a.type + "\t");
		System.out.print(a.price + "\t");
		System.out.print(a.sale + "\t");
		System.out.println();

		System.out.print(b.menu + "\t");
		System.out.print(b.type + "\t");
		System.out.print(b.price + "\t");
		System.out.print(b.sale + "\t");
		System.out.println();

		System.out.print(c.menu + "\t");
		System.out.print(c.type + "\t");
		System.out.print(c.price + "\t");
		System.out.print(c.sale + "\t");
		System.out.println();

		System.out.print(d.menu + "\t");
		System.out.print(d.type + "\t");
		System.out.print(d.price + "\t");
		System.out.print(d.sale + "\t");
		System.out.println();

	}

}
