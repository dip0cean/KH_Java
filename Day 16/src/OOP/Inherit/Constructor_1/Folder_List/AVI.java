package OOP.Inherit.Constructor_1.Folder_List;

import OOP.Inherit.Constructor_1.Program.Player;

public class AVI extends Player {
//	AVI 데이터	
	protected double speed;

//	부모 클래스 생성자 오버 라이딩
	public AVI(String fileName, long fileSize, double speed) {
		super(fileName, fileSize);
		this.speed = speed;
	}

	public AVI(String fileName) {
		super(fileName, 0L);
		this.speed = 1.0;
	}

//	부모 클래스 메소드 오버 라이딩
	public void execute() {
		System.out.println(" - 현재 영상을" + this.speed + "배속으로 재생합니다.");
	}

	public void forward() {
		System.out.println(" - 현재 재생 중인 영상을 빨리 감는 중 입니다.");
	}

	public void rewind() {
		System.out.println(" - 현재 재생 중인 영상을 되감기 하는 중 입니다.");
	}

//	Setter / Getter
	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public double getSpeed() {
		return speed;
	}

//	Output Method	
	public void output() {
		System.out.println("< AVI : " + super.fileName + ".avi / " + super.fileSize + "Byte / x" + getSpeed() + "배속 >");
	}

}
