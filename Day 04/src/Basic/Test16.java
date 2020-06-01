package Basic;


public class Test16 {
	public static void main(String[] args) {
//		문자열 : String (대문자 확인) > 참조형 
		
		String a = "Hello!";
		System.out.println(a);
		System.out.println(a.length());
		System.out.println(a.toUpperCase());
		System.out.println(a.charAt(1));
		
//		나는 "피자"가 먹고 싶어요. 를 문자열 변수에 저장한 뒤 출력
//		"" 를 출력하고 싶다면 역슬래쉬를 통해 따옴표를 출력할 것이라고 알려줘야 함. (Escape Sequence > 조합 글자)
		String b = "나는\"피자\"가 먹고 싶어요";
		System.out.println(b);

//		\t 의 간격은 글씨체(폰트)에 따라 다르다.
		String c = "이름\t성별";
		String d = "원빈\t남자";
		String e = "이나영\t여자";
		System.out.println(c);
		System.out.println(d);
		System.out.println(e);
		
//		\t : tab 키 / \n : Enter 키 
	}
}
