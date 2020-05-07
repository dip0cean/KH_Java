package OOP.Constructor_1;

public class Member {
//	멤버 필드 > 데이터 저장
	String id, pw, grade;
	boolean power;
	int point;

//	생성자
	Member(String id, String pw) {
		this(id, pw, false);
	}

	Member(String id, String pw, boolean power) {
		this.id = id;
		this.pw = pw;
		this.power = power;
		if (this.power == true) {
			this.grade = "운영자";
			this.point = 999999;
		} else {
			this.grade = "일반 회원";
			this.point = 100;
		}
	}

//	메소드
	void output() {
		System.out.println("[ 회원 정보 ]");
		System.out.println("ID : " + this.id);
		System.out.println("PW : " + this.pw);
		System.out.println("권한 : " + this.grade);
		System.out.println("포인드 : " + this.point);
		System.out.println();
	}
}
