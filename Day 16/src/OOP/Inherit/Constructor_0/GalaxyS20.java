package OOP.Inherit.Constructor_0;

//	문제점 : 부모 클래스의 생성자를 맞춰주지 못했기 때문에 에러 발생
public class GalaxyS20 extends Phone {
//	public GalaxyS20 () {
//		super():
//	}

//	해결책 : 부모 클래스의 생성자를 맞춰준다.
	private int sdCard;
	
	

	public int getSdCard() {
		return sdCard;
	}



	public void setSdCard(int sdCard) {
		this.sdCard = sdCard;
	}



	public GalaxyS20(String num, String telecom, int sdCard) {
		super(num, telecom); // 부모 클래스에  생성자가 만들어졌을 때 부모 클래스의 생성자를 호출하는 코드 > 순서는 첫번째
		this.sdCard = sdCard;
	}
}
