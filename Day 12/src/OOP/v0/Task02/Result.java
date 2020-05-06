package OOP.v0.Task02;

public class Result {

	public static void main(String[] args) {

//		객체 선언		
		Score a0 = new Score();
		Score a1 = new Score();
		Score a2 = new Score();
		Score a3 = new Score();

//		객체 정보 입력
		a0.setting();
		a1.setting("통키", 80);
		a2.setting("슛돌이", 55, 90);
		a3.setting("피카츄", 77, 65, 23);

//		객체 출력		
		a0.output();
		a1.output();
		a2.output();
		a3.output();

	}

}
