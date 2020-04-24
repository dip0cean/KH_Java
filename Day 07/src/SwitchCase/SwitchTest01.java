package SwitchCase;

import java.lang.*;
import java.util.Random;

public class SwitchTest01 {

	public static void main(String[] args) {
//		switch ~ case 를 이용한 가위바위보

		Random r = new Random();

		int i = r.nextInt(3);

		switch (i) {
		
		case 0:
			System.out.println("가위");
			break;
		case 1:
			System.out.println("바위");
			break;
		default:
			System.out.println("보");
			break;
		}

	}

}
