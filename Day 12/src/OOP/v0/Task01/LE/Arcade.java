package OOP.v0.Task01.LE;

public class Arcade {
	String name;
	int price;
	int income;

//	메소드 오버로딩	
	public void play() {
		this.play(1);
	}

	public void play(int count) {
		this.income += this.price * count;
	}

	void setting(String name, int price) {
		this.setting(name, price, 1); // 중복 코드 제거 (몰아 주기)
	}
	
	void setting(String name, int price, int income) {
		this.name = name;
		this.price = price;
		this.income = income * price;
	}
	
//	메소드 오버로딩	

	void output() {
		System.out.println("[오락기 정보]");
		System.out.println("이름 : " + this.name);
		System.out.println("가격 : " + this.price + "원");
		System.out.println("누적 수입 : " + this.income + "원");
		System.out.println();
	}

}
