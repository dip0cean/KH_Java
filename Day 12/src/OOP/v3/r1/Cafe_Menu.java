package OOP.v3.r1;

public class Cafe_Menu {
//	코드를 저장하기 위해서는 메소드(method) 생성
//	함수와 메소드는 비슷하지만 같지는 않음
//		1) 함수 : 누군가에 의한 보호막이 없음
//		2) 메소드 : 누군가에 의한 보호막이 있음 > class 안에 method 존재

//	멤버 필드 > 데이터를 저장
	String menu;
	String type;
	int price;
	boolean sale;

//	멤퍼 메소드 > 코드 저장
// this == 현재 객체(나 자신)을 의미	
	void output() {

		System.out.print(this.menu + "\t");
		System.out.print(this.type + "\t");
		System.out.print(this.price + "원\t");
		System.out.print(this.sale + "\t");
		System.out.println();
	}

//	( ) 안에는 외부에서 전달되는 데이터를 저장할 변수를 선언
//		-> 매개 변수 (메소드 실행을 위한 준비물)
	void setting(String a, String b, int c, boolean d) {
		this.menu = a;
		this.type = b;
		this.price = c;
		this.sale = d;
	}
}
