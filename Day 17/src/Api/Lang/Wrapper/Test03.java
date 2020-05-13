package Api.Lang.Wrapper;

public class Test03 {
	public static void main(String[] args) {
//		auto - boxing / auto - unboxing
//		int 와 Integer 처럼 하이브리드 지원이 필요한 상황이면 자동 변환을 수행한다.
//		Wrapper 클래스 > 기본형 타입 개수와 같다. > 기본형을 포장(메소드 안에서 연산)해서 내보내기 때문이다. 

//		int > Integer
//		double > Double
//		byte > Byte
//		short > Short
//		long > Long
//		float > Float
//		boolean > Boolean

		Integer a = 10;
		Integer b = 20;
		//	auto - unboxing > 변수 연산은 불가능 하지만, 
		//	어차피 숫자로 연산할 것을 예상해서 Integer > int > Integer
		//	과정이 된다. 즉, unboxing > boxing 의 과정이다.
		Integer c = a + b;
		System.out.println(c);

//		Integer d = 10; int > Integer (o)
//		Long d = 10; int > Long (x)
		Long d = 10L; // long > Long (o)
		System.out.println(d);
	}
}
