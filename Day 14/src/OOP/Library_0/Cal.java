package OOP.Library_0;

import java.util.Random;
/**
 * Funny JAVA~
 * @author ME
 */
public class Cal {
	/**
	 * JEGOP 
	 * @param a UJJEGU~
	 * @return a JEJJEGU~
	 */
	public static int square(int a) {
		return a * a;
	}
	
	public static double circle(int a) {
		return a * a * Math.PI;
	}
	
	public static int dice() {
		Random r = new Random();
		return r.nextInt(6) + 1;
	}
}
