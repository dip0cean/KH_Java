package OOP.Modifier_2;

public class Result {

	public static void main(String[] args) {

		Room a = new Room(21, 2, 2, false, 300000000);

		a.output();
		
		Room b = new Room(34, 3, 1, true, 350000000);

		b.output();
		
		Room c = new Room(31, 3, 0, false, 400000000);

		c.output();

	}

}
