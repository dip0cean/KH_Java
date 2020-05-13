package Api.Lang.Object;

import java.util.Random;
import java.util.Scanner;

public class Test02 {
	public static void main(String[] args) {
//		상속 관계에서의 Up Casting
		Object a = 100;
		Object b = "안녕";
		Object c = 1.5;
		Object d = true;
		Object e = new int[5];
		@SuppressWarnings("resource")
		Object f = new Scanner(System.in); // 사용하기 위해서는 Down Casting
		Object g = new Random();

//		b의 자료형은 ?
//		보관형 > Object / 실제 형태 > String
		System.out.println(a.getClass() + "<- 클래스의 종류");
		System.out.println(b.getClass() + "<- 클래스의 종류");
		System.out.println(c.getClass() + "<- 클래스의 종류");
		System.out.println(d.getClass() + "<- 클래스의 종류");
		System.out.println(e.getClass() + "<- 클래스의 종류");
		System.out.println(f.getClass() + "<- 클래스의 종류");
		System.out.println(g.getClass() + "<- 클래스의 종류");
		Double h = 100.5;
		System.out.println(h.getClass() + "<- 클래스의 종류");
	}

}
