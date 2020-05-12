package OOP.Inherit.Constructor_1.Folder_List;

import OOP.Inherit.Constructor_1.Program.Player;

public class MP3 extends Player {
//	MP3 데이터
	protected int duration;

//	부모 클래스 생성자 오버 라이딩
	public MP3(String fileName, long fileSize, int duration) {
		super(fileName, fileSize);
		this.duration = duration;
	}

	public MP3(String fileName) {
		super(fileName, 0L);
		this.duration = 0;
	}

// 부모 클래스 메소드 오버 라이딩
	public void execute() {
		System.out.println(" - 현재 음악 재생을 시작합니다.");
	}

	public void forward() {
		System.out.println(" - 현재 재생 중인 음악을 빨리 감는 중 입니다.");
	}

	public void rewind() {
		System.out.println(" - 현재 재생 중인 음악을 되감기 하는 중 입니다.");
	}

//	Setter / Getter	
	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getDuration() {
		return duration;
	}

// Output Method
	public void output() {
		System.out
				.println("< MP3 : " + super.fileName + ".mp3 / " + super.fileSize + "Byte / " + getDuration() + "초 >");
	}

}
