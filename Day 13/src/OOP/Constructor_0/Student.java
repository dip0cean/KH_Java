package OOP.Constructor_0;

public class Student {
//	Field (인스턴스 변수)	
	String name;
	int score;

//	Constructor
	// - 이 클래스의 생성 방법을 정의하는 구문
	// - 생성자는 메소드의 특수화 형태
	//	- 객체 생성 시 1회만 호출
	//	- 객체의 데이터를 생성시 초기화하는 역할 수행
	//	- Over Loading 가능 ( 클래스와 이름이 같아야 함)
	Student(String name, int score) {
		this.name = name;
		this.score = score;
	}
	
	Student(String name) {
		this(name, 0);
	}

//	Method	
	void setting(String name, int score) { // 매개 변수
		this.name = name;
		this.score = score;
	}

	void output() {
		System.out.println(this.name);
		System.out.println(this.score);
	}
}
