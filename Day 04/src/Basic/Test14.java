package Basic;


public class Test14 {
	public static void main(String[] args) {
//		실수의 특징에 대해서 톺아보자
		float a = 3.14f;
		double b = 3.14;
		System.out.println(a);
		System.out.println(b);

		float c = 1.158498435498435416843541684321684654321832413598432168498743541f;
		double d = 1.158498435498435416843541684321684654321832413598432168498743541;

//sysout + ctrl + space > Systm.out.println();
		System.out.println(c);
		System.out.println(d);

		System.out.println(10 / 3.0);

//		실수가 정수보다 크다.
		float e = 1.5f;
		long t = (long) e; // float 타입이 long 타입보다 크다는 증명
		System.out.println(t);

		long g = 10L;
		float h = g; // long 타입이 float 타입보다 크다는 증명
		System.out.println(h);
	}
}
