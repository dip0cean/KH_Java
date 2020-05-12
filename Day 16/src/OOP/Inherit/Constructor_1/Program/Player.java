package OOP.Inherit.Constructor_1.Program;

import OOP.Inherit.Constructor_1.File.File;

public class Player extends File {
//	부모 클래스 생성자 오버 라이딩
	public Player(String fileName, long fileSize) {
		super(fileName, fileSize);
	}

	public Player(String fileName) {
		super(fileName, 0L);
	}

//	기능 메소드
	public void execute() {
		System.out.println("재생합니다.");
	}

	public void forward() {
		System.out.println("빨리감기를 시작합니다.");
	}

	public void rewind() {
		System.out.println("되감기를 시작합니다.");
	}
}
