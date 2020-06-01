package Task;


public class Task03_2 {

	public static void main(String[] args) {
//		피보나치 수열
		int a = 1, b = 1;
		int c = a + b;

		for (int i = 4; i < 30; i++) {
			a = b;
			b = c;
			c = a + b;
			System.out.println("c = " + c);
		}

	}

}
