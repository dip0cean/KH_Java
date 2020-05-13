package Api.Lang.String_0;

public class Test01 {
	public static void main(String[] args) {
		String a = "hello world!"; // 기존에 쓰던 방식 (new 코드가 없기 때문에 Heap 메모리를 사용하지 못함.)
		String b = new String("hello world!");
		String c = "HELLO WORLD!";
		
		System.out.println(a == b);
		System.out.println(b.equals(a));
		System.out.println(c.equals(b)); // 대소문자 구분 메소드
		System.out.println(c.equalsIgnoreCase(b)); // 대소문자 무시 메소드
	}
}
