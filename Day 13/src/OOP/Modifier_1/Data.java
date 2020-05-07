package OOP.Modifier_1;

public class Data {

	public static void main(String[] args) {
		Phone a = new Phone("APPLE | iPhone11", "KT", 1600000, 24);

		a.output();

		Phone b = new Phone("SAMSUNG | Galaxy20s", "SKT", 1550000, 18);

		b.output();

		Phone c = new Phone("LG | Velvet", "LGU+", 880000, 24);

		c.output();

		Phone d = new Phone("SONY | Xperia X1", "알뜰폰", 945000, 17);

		d.setAgency("알뜰폰");
		d.setPrice(945000);
		d.setContract(18);

		d.output();

		Phone e = new Phone("LG | 와인폰", "알뜰폰", 9500, 10);

		e.setAgency("알뜰폰");
		e.setPrice(95000);
		e.setContract(-6);

		e.output();

	}

}
