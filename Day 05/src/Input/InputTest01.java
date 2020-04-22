package Input;

import java.io.IOException;
import java.lang.*;

public class InputTest01 {

	public static void main(String[] args) throws IOException {
//		표준 입력 통로(System.in)를 이용하여 한글자씩 입력받기

		int a = System.in.read();
		int b = System.in.read();
		System.out.println(a);
		System.out.println(b);

		System.out.println((a - 48) * 10 + (b - 48));

	}

}
