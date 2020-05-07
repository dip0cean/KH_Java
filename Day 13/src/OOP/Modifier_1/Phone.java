package OOP.Modifier_1;

public class Phone {
//	통신사는 SK / KT / LGU+ / 알뜰폰 중 하나만 설정할 수 있다.
//	가격은 음수로 설정할 수 없다.
//	약정 기간은 6개월 단위로만 설정할 수 있다.

//	필드	
	private String won;
	private String month;
	private String phone;
	private String agency;
	private int price;
	private int contract;


//	Setter Method
	public void setPrice(int price) {
		// 가격
		if (price > -1 && price > 10000) {
			this.price = price / 10000;
			this.won = "만원";
		} else if (price > -1 && price < 10000) {
			this.price = price;
			this.won = "원";
		}
	}

	public void setContract(int contract) {
		// 약정
		if (contract % 6 == 0 && contract > 0) {
			this.contract = contract;
			this.month = " 개월";
		} else {
			this.contract = 6;
			this.month = "개월 단위로 다시 입력해주세요.";
		}
	}

	public void setAgency(String agency) {
		// 통신사
		switch (agency.toLowerCase()) {
		case "skt":
		case "kt":
		case "lgu+":
		case "알뜰폰":
			this.agency = agency;
			break;
		default:
			this.agency = "통신사를 다시 입력해주세요.";
			break;
		}
	}

//	Getter Method	

	private String getPhone() {
		System.out.println("[ 휴대폰 계약 정보 ]");
		System.out.print("기기명 : ");
		return this.phone;
	}

	private String getAgency() {
		System.out.print("통신사 : ");
		return this.agency;
	}

	private int getPrice() {
		System.out.print("가격 : ");
		return this.price;
	}

	private int getContract() {
		System.out.print("약정 기간 : ");
		return this.contract;
	}

	private String getWon() {
		return this.won;
	}

	private String getMonth() {
		return this.month;
	}

//	생성자
	public Phone(String phone, String agency, int price, int contract) {
		this.phone = phone;
		this.setAgency(agency);
		this.setPrice(price);
		this.setContract(contract);
	}
	
//	출력 메소드	
	public void output() {
		System.out.println(this.getPhone());
		System.out.println(this.getAgency());
		System.out.println(this.getPrice() + this.getWon());
		System.out.println(this.getContract() + this.getMonth());
		System.out.println();
	}

}
