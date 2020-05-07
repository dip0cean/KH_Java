package OOP.Modifier_3;

public class User {

	String id, nick, grade, shipping;

	Shipping a = new Shipping("00853", "서울시 어쩌구 금은동", "겨울 아파트 101동 303호");
	Shipping b = new Shipping("02870", "대전시 어쩌구 저쩌동", "산중턱 39 - 1");

	private void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return this.id;
	}

	private void setNick(String nick) {
		this.nick = nick;
	}

	public String getNick() {
		return this.nick;
	}

	private void setGrade(String grade) {
		this.grade = grade;
	}

	public String getGrade() {
		return this.grade;
	}

	public User(String id, String nick, String grade) {
		this.setId(id);
		this.setNick(nick);
		this.setGrade(grade);
	}

	public String getTotal() {
		if (this.id.equals("test01")) {
			return a.total();
		} else if (this.id.equals("test02")) {
			return b.total();
		} else {
			return "배송지 : 없음";
		}
	}

	public void output() {
		System.out.println("아이디 : " + this.getId());
		System.out.println("닉네임 : " + this.getNick());
		System.out.println("등급 : " + this.getGrade());
		System.out.println(this.getTotal());
		System.out.println();
	}
}
