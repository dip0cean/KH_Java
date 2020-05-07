package OOP.Modifier_3;

public class User {

//	배송지 입력
	Shipping a = new Shipping("00853", "서울시 어쩌구 금은동", "겨울 아파트 101동 303호");
	Shipping b = new Shipping("02870", "대전시 어쩌구 저쩌동", "산중턱 39 - 1");
	Shipping c = new Shipping("02460", "제주시 이러쿵 저러쿵동", "한라산 맨꼭대기");

	public String getTotal() {
		switch (this.id) {
		
		case "test01":
			return a.total();
		case "test02":
			return b.total();
		case "test03":
			return c.total();
		default:
			return "배송지 : 없음";
		}
	}
	
//	Field	
	String id, nick, grade, shipping;

//	Setter / Getter Method	
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

//	Constructor	
	public User(String id, String nick, String grade) {
		this.setId(id);
		this.setNick(nick);
		this.setGrade(grade);
	}

//	Output Method
	public void output() {
		System.out.println("아이디 : " + this.getId());
		System.out.println("닉네임 : " + this.getNick());
		System.out.println("등급 : " + this.getGrade());
		System.out.println(this.getTotal());
		System.out.println();
	}
}
