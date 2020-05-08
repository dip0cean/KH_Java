package OOP.Final_1;

public class Member {
//	Final 항목은 반드시 생성자에서 초기화 되어야 한다.	
	private final String id;
	private String pw;

	public Member(String id) {
		this.id = id;
	}

	public Member(String id, String pw) {
		this.id = id;
		this.pw = pw;
	}

	public String getId() {
		return this.id;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getPw() {
		return this.pw;
	}
}
