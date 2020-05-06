package OOP.v3.r1;

public class Cafe {

	public static void main(String[] args) {

//		객체 생성		
		Cafe_Menu m1 = new Cafe_Menu();
		Cafe_Menu m2 = new Cafe_Menu();
		Cafe_Menu m3 = new Cafe_Menu();
		Cafe_Menu m4 = new Cafe_Menu();

//		각 객체에 정보 입력		
		m1.setting("아메리카노", "음료", 1800, true);
		m2.setting("프라푸치노", "음료", 3500, false);
		m3.setting("파니니", "식사", 2800, true);
		m4.setting("크로크무슈", "식사", 3300, false);

//		출력
//		m(x) 를 주인공으로 하여 output() 의 코드를 실행 (this)		
		m1.output();
		m2.output();
		m3.output();
		m4.output();

	}

}
