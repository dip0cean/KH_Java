package OOP.Static_4;

public class SafeBox {
//	기본 이율은 모든 가입자에게 동일하게 적용된다.
//	우대 이율은 가입자마다 다르게 적용된다.
//	예금액은 음수로 설정할 수 없다.	

// Static	
	static double rate = 2; // 기본 이율

//	Instance (Dynamic)
	private String name; // 이름
	private double preRate; // 우대 이율
	private long deposit; // 예금액

//	Setter / Getter	
	
	private void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	private void setPreRate(double preRate) {
		this.preRate = preRate;
	}

	private double getPreRate() {
		return this.preRate;
	}

	private void setDeposit(long deposit) {
		if (deposit > -1) {
			this.deposit = deposit;
		}
	}

	private long getDeposit() {
		return this.deposit;
	}

	public SafeBox(String name, double preRate, int deposit) {
		this.setName(name);
		this.setPreRate(preRate);
		this.setDeposit(deposit);
	}

	public String CustomerData() {
		return "이름 : " + this.getName() + "\n기본 이율 : " + rate + "%\n우대 이율 : " + this.getPreRate() + "%\n예금액 : "
				+ this.getDeposit() / 10000 + "만원\n";
	}

	public void output() {
		System.out.println(this.CustomerData());
	}
}
