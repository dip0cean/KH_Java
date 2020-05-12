package OOP.Inherit.Constructor_1.Folder_List;

import OOP.Inherit.Constructor_1.Program.Player;

public class PPT extends Player {
//	PPT 데이터	
	protected int page;

//	부모 클래스 메소드 오버 라이딩	
	public PPT(String fileName, int fileSize, int page) {
		super(fileName, fileSize);
		this.page = page;
	}

	public PPT(String fileName) {
		super(fileName, 0L);
		this.page = 1;
	}

// 부모 클래스 메소드 오버 라이딩
	public void execute() {
		System.out.println(" - 파워포인트 애니메이션을 재생합니다.");
	}

//	Setter / Getter	
	public void setPage(int page) {
		this.page = page;
	}

	public int getPage() {
		return this.page;
	}

//	Output Method	
	public void information() {
		System.out.println("< PPT : " + super.fileName + ".ppt / " + super.fileSize + "Byte / " + getPage() + "p >");
	}

}
