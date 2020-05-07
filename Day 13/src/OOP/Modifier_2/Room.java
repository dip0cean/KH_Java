package OOP.Modifier_2;

public class Room {
//	아파트 평형은 25 / 31 / 34 / 45 평형만 존재한다.
//	방 개수는 최소 1개이다.
//	화장실은 1개 이상 있어야 한다.
//	가격은 0 이상이며, 100만원 밑으로는 버리고 설정한다.
//	발코니를 확장하지 않은 경우 5% 할인하여 가격을 확인할 수 있도록 해야 한다.

//	Field	
	private String caution;
	private String OX;
	private String rCount;
	private String tCount;
	private int size;
	private int room;
	private int toilet;
	private int price;
	private boolean balcony;

//	Setter Method	
	private void setSize(int size) {
		switch (size) {
		case 25:
		case 28:
		case 31:
		case 34:
		case 45:
			this.size = size;
			caution = "평형";
			break;
		default:
			this.size = size;
			caution = "평형은 없는 조건입니다.";
			break;
		}
	}

	private void setRoom(int room) {
		if (room > 0) {
			this.room = room;
			rCount = "개";
		} else {
			this.room = room;
			rCount = "개는 없는 조건입니다.";
		}
	}

	private void setToilet(int toilet) {
		if (toilet > 0) {
			this.toilet = toilet;
			tCount = "개";
		} else {
			this.toilet = toilet;
			tCount = "개는 없는 조건입니다.";
		}
	}

	private void setPrice(int price) {
		this.price = price;
		if (price > 0) {
			if (balcony == false) {
				this.price = price - (int) (price * 0.05);
			} else {
				this.price = price;
			}
		}
	}

	private void setBalcony(boolean balcony) {
		this.balcony = balcony;
		if (balcony == true) {
			OX = "O";
		} else {
			OX = "X";
		}
	}

//	Getter Method	
	private int getSize() {
		return this.size;
	}

	private int getRoom() {
		return this.room;
	}

	private int getToilet() {
		return this.toilet;
	}

	private int getPrice() {
		return this.price;
	}

//	Constructor	
	public Room(int size, int room, int toilet, boolean balcony, int price) {
		this.setSize(size);
		this.setRoom(room);
		this.setToilet(toilet);
		this.setBalcony(balcony);
		this.setPrice(price);
	}

//	Output Method	
	public void output() {
		System.out.println(" [ 부동산 정보 ] ");
		System.out.println("평형 : " + this.getSize() + this.caution);
		System.out.println("방 : " + this.getRoom() + this.rCount);
		System.out.println("화장실 : " + this.getToilet() + this.tCount);
		System.out.println("발코니 확장 여부 : " + this.OX);
		if (this.getPrice() % 100000000 == 0) {
			System.out.println("가격 : " + (this.getPrice() / 100000000) + "억");
		} else if (this.getPrice() % 100000000 != 0) {
			System.out.println(
					"가격 : " + (this.getPrice() / 100000000) + "억 " + ((this.getPrice() % 100000000) / 10000000) + "천");
		}
		System.out.println();
	}
}
