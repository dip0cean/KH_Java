package Api.Lang.Object;

public class Test01 {
	public static void main(String[] args) {
//		남이 만든 클래스인 Object를 사용
		Object a = new Object();

		String a1 = a.toString(); // 객체의 요약 정보
		System.out.println(a1);
		
		int a2 = a.hashCode(); //	코드의 일련번호 반환
		System.out.println(a2);
		
		Object b = new Object();
		String b1 = b.toString();
		System.out.println(b1);
		
		int b2 = b.hashCode();
		System.out.println(b2);
	}
}
