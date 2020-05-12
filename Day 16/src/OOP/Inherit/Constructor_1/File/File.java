package OOP.Inherit.Constructor_1.File;

public class File {
//	데이터
	protected String fileName;
	protected long fileSize;

//	생성자	
	protected File(String fileName, long fileSize) {
		this.fileName = fileName;
		this.fileSize = fileSize;
	}

//	생성자 오버 로딩	
	protected File(String fileName) {
		this(fileName, 0L);
	}

}
