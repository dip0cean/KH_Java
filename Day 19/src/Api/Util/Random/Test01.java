package Api.Util.Random;

import java.util.Random;

public class Test01 {
	public static void main(String[] args) {
		Random r = new Random();
		System.currentTimeMillis();
		Random r2 = new Random(1L);
		
		System.out.println(r.nextDouble()); // == Math.random();
		System.out.println(r.nextGaussian()); // == 가우시안 분포 == 정규 분포
		System.out.println(r2.nextInt());
		
	}
}
