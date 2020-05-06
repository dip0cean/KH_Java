package OOP.v0.Task01.D0;

public class Arcade {
	String name;
	int price;
	int play;
	int total;
	
	void setting(String name, int price, int play) {
		this.name = name;
		this.price = price;
		this.play = play;
		this.total = this.price * this.play;
	}

	void output() {
		System.out.print(this.name + " \t|\t");
		System.out.print(this.price + "원 \t|\t");
		System.out.print(this.total + "원 \t|\t");
		System.out.println();
	}

}
