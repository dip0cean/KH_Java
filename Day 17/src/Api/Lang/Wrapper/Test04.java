package Api.Lang.Wrapper;

public class Test04 {
	public static void main(String[] args) {
//		주의사항 > 데이터의 값은 같을 수 있지만, 메모리에 저장된 주소가 다르다.
		Integer a = new Integer(10);
		Integer b = new Integer(10);
		
//		a 와 b 는 다르다. 객체가 다르기 때문에 변수에 저장된 주소가 다르다.
//		객체 비교는 .equals() 메소드를 사용한다. (같은지 X 동등한지 O)		
		boolean c = a == b;
		System.out.println("a 와 b 는 같은가 ?  " + c);
		System.out.println("a 와 b 는 동등한가 ? " + a.equals(b));
	}
}
