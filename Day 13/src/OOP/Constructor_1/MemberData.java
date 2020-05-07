package OOP.Constructor_1;

public class MemberData {

	public static void main(String[] args) {
		Member a1 = new Member("tester", "test1234");
		Member a2 = new Member("user", "user1234", true);
		Member admin = new Member("admin", "admin1234");

		a1.output();
		a2.output();
		admin.output();

	}

}
