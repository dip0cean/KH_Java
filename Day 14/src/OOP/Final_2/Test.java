package OOP.Final_2;

import java.util.Random;

public class Test {
	public static void main(String[] args) {

		Random r = new Random();

		int rsp = r.nextInt(4);

		switch (rsp) {
		case RSP.SCISSORS:
			System.out.println("가위");
			break;
		case RSP.ROCK:
			System.out.println("바위");
			break;
		default:
			System.out.println("보");
			break;

		}
	}
}
