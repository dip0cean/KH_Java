package OOP.Constructor_2;

import java.util.Random;

class Dice {

	int first;
	int second;

//	옵션 1 : 랜덤 생성하는 방법	
	Dice() { // 기본 생성자 : 매개 변수가 하나도 없는 생성자
		Random r = new Random();

		this.first = r.nextInt(6) + 1;
		this.second = r.nextInt(6) + 1;
	}

//	옵션 2 : 값을 집어 넣어서 생성하는 방법
	Dice(int first, int second) {
		this.first = first;
		this.second = second;
	}

	void output() {
		System.out.println("1st : " + this.first);
		System.out.println("2nd : " + this.second);
		System.out.println();
	}

}
