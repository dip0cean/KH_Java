package Basic;

import java.lang.*;
import java.util.*;

public class Test02 {
	public static void main(String[] args) {
		// 자장면 한 그릇 5000원 
		// 짬뽕 한 그릇 6000원 
		Scanner sc = new Scanner(System.in);
		int x, y;
		x = sc.nextInt();
		y = sc.nextInt();
		
		int i = 5000;
		int k = 6000;
		int result = (i * x) + (k * y);
		System.out.println("총 합계 : " + result + "원");
	}
}
