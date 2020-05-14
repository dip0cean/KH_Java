package Api.Lang.String;

public class Test02 {
	public static void main(String[] args) {
//		문자열 변환(기본형의 문자열화)

//		-	변환 : .valueOf()
		// 기본형 데이터 > 문자열 변환
		int a = 100;
		String a1 = String.valueOf(a);
		System.out.println("int > String : " + a1);

		// 참조형 데이터 > 기본형 데이터
		String b = "1234";
		int b1 = Integer.parseInt(b);
		System.out.println("String > int : " + b1);

		String c = "1234";
		long c1 = Long.parseLong(c);
		System.out.println("String > long : " + c1);

		// 참조형 데이터를 String 타입의 참조형 데이터로 변경
		// Object 데이터가 null 일 경우 예외처리 발생
		// Integer == int ?
		// int 는 기본형 데이터 타입 / Integer 는 int의 참조형 데이터 타입
		// 그렇기에 만약 값이 없다면 null로 대체 가능하다
		//	Integer intvalue = null;
		//	String d1 = Integer.toString(intvalue);

	}

}
