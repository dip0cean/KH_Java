package Api.Util.Arrays;

import java.util.Arrays;

public class Test01 {
	public static void main(String[] args) {
//		Arrays 클래스 : 배열 보조 도구		

		int[] data = new int[10];

		System.out.println(Arrays.toString(data));

		Arrays.fill(data, 10);
		System.out.println(Arrays.toString(data));
	}
}
