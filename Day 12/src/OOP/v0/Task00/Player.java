package OOP.v0.Task00;

public class Player {
//	Member Field
	String nickname;
	String job;
	int level;
	int gold;

//	Member Method (설정 메소드)
	void setting(String nickname, String job, int level, int gold) {
		this.nickname = nickname;
		this.job = job;
		this.level = level;
		this.gold = gold;
	}

//	Member Method (출력 메소드)
	void output() {
		System.out.print(this.nickname + " | ");
		System.out.print(this.job + " | ");
		System.out.print(this.level + ".Lv | ");
		System.out.print(this.gold + "골드\t");
		System.out.println();
	}

}
