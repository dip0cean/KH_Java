package OOP.Inherit.Abstract_1;

public class Test {
	public static void main(String[] args) {
//		정적 타입
		GalaxyS20 a = new GalaxyS20();
		iPhone11 b = new iPhone11();
		
		a.call();
		b.call();

		
//		동적 타입		
		Phone c = new GalaxyS20();
		Phone d = new iPhone11();
		
		c.call();
		d.call();
		
	}
}
