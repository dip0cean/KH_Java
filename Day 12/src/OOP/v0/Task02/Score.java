package OOP.v0.Task02;

public class Score {
//	필드	
	String name;
	int kor;
	int eng;
	int math;
	int sum;
	double avg;

//	연산 메소드	
	void setting() {
		this.setting("이름을 입력해주세요.", 0, 0, 0);
	}

	void setting(String name) {
		this.setting(name, 0, 0, 0);
	}

	void setting(String name, int kor) {
		this.setting(name, kor, 0, 0);
	}

	void setting(String name, int kor, int eng) {
		this.setting(name, kor, eng, 0);
	}

	void setting(String name, int kor, int eng, int math) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.sum = kor + eng + math;
		this.avg = ((int) (((this.sum) / 3.0) * 10)) / 10.0;
	}

//	출력 메소드	
	void output() {
		System.out.println("이름 : " + this.name);
		System.out.println("총점 : " + this.sum + "점");
		System.out.println("평균 : " + this.avg + "점");
		System.out.println();
	}

}
