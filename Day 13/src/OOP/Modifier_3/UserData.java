package OOP.Modifier_3;

public class UserData {
	private User a = new User("test01", "뽀야미", "골드");
	private User b = new User("test02", "자바조아", "실버");
	private User c = new User("test03", "룰루랄라", "브론즈");
	private User d = new User("test04", "배고파", "VIP");
	
	
	public UserData(String id) {
		switch(id) {
		case "test01" :
			a.output();
			break;
		case "test02" :
			b.output();
			break;
		case "test03" :
			c.output();
			break;
		case "test04" :
			d.output();
			break;
		default :
			System.out.println("아이디를 다시 입력하세요.");
			break;
			
		}
	}
}
