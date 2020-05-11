package OOP.Inherit_5;

public class Galaxy extends Phone {
//	출력 메소드
	void output() {
		System.out.println("번호 : " + this.num);
	}
//	상속 받은 메소드를 수정할 때 하나 더 만든다.
//	단, 똑같은 형태로 한다.
//	> Method Over Ride
	
	public void info() {
		System.out.println("이 휴대폰 제조사는 삼성입니다.");
	}
}
