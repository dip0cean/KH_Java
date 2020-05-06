package OOP.v2;

public class Sport_Player {

	public static void main(String[] args) {

		Player_1 a = new Player_1();
		Player_2 b = new Player_2();
		Player_3 c = new Player_3();

		a.name = "김연아";
		a.event = "피켜 스케이트";
		a.gold = 3;
		a.silver = 3;
		a.copper = 0;
		System.out.print(a.name + "\t");
		System.out.print(a.event + "\t");
		System.out.print(a.gold + "\t");
		System.out.print(a.silver + "\t");
		System.out.print(a.copper + "\t");
		System.out.println();

		b.name = "이상화";
		b.event = "스피드 스케이트";
		b.gold = 2;
		b.silver = 3;
		b.copper = 3;
		System.out.print(b.name + "\t");
		System.out.print(b.event + "\t");
		System.out.print(b.gold + "\t");
		System.out.print(b.silver + "\t");
		System.out.print(b.copper + "\t");
		System.out.println();

		c.name = "윤성빈";
		c.event = "스켈레톤";
		c.gold = 1;
		c.silver = 0;
		c.copper = 1;
		System.out.print(c.name + "\t");
		System.out.print(c.event + "\t\t");
		System.out.print(c.gold + "\t");
		System.out.print(c.silver + "\t");
		System.out.print(c.copper + "\t");
		System.out.println();
	}

}
