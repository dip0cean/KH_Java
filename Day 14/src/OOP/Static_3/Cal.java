package OOP.Static_3;

import java.util.Random;

public class Cal {

//	1. 매개 변수의 제곱 값을 구하라.	
	public static int square(int a) {
		return a * a;
	}
	
//	2. 매개 변수를 이용해 원의 넓이를 구하라.
	public static double circle(int a) {
		return a * a * Math.PI;
	}
	
//	3. 주사위의 값을 구하라.	
	public static int dice() {
		Random r = new Random();
		return r.nextInt(6) + 1;
	}
}
