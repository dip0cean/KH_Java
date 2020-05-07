package OOP.Modifier_3;

public class Order {

	public static void main(String[] args) {

		User a = new User("test01", "뽀야미", "골드");
		User b = new User("test02", "야미야미", "실버");
		User c = new User("test03", "자바는재밌어", "브론즈");

		a.output();
		b.output();
		c.output();
	}

}
