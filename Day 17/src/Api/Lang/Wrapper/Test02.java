package Api.Lang.Wrapper;

public class Test02 {
	public static void main(String[] args) {
//		Interger 를 이용해서 문제를 풀어보자!
		String str = Integer.toBinaryString(63);
		System.out.println(str);
		
//		10 + 20 = ?
		Integer a = new Integer(10);
		Integer b = new Integer(20);
		
		Integer c = Integer.sum(a, b);
		System.out.println(c.toString());
		
	}
}
