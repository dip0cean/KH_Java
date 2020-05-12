package OOP.Inherit.Constructor_0;

public class Test {
	public static void main(String[] args) {
		GalaxyS20 a = new GalaxyS20("01094676216", "KT", 256);
		System.out.println(a.num);
		System.out.println(a.telecom);
		System.out.println(a.getSdCard());
		
		GalaxyS20 b = new GalaxyS20("01044556677", "SKT", 512);
		System.out.println(b.num);
		System.out.println(b.telecom);
		System.out.println(b.getSdCard());

	}

}
