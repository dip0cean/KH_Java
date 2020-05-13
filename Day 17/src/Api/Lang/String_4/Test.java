package Api.Lang.String_4;

public class Test {
	public static void main(String[] args) {
//		문자열 편집
//		-	대소문자 변환
//		-	불필요한 여백 제거	
//		-	치환 		

		//	대소문자 변환
		String str = "Hello World!";
		System.out.println(str.toLowerCase()); // .toLowerCase() > 소문자로 변환
		System.out.println(str.toUpperCase()); // .toUpperCase() > 대문자로 변환

		
		//	불필요한 여백 제거
		String url = "                              HTTP://WWW.NAVER.COM";

		System.out.println(url.trim()); // .trim() > 불필요한 여백 제거
		System.out.println(url.toLowerCase()); // url 소문자로 만들어 버리기
		
		//	치환 (텍스트 편집 기능)
		String test = "나는 자바가 좋아요";
		System.out.println(test);
		System.out.println(test.replace("자바" , "피자"));
		System.out.println(test.replace("좋아" , "싫어"));
		test = test.replace("좋아", "싫어");
		System.out.println(test);
	}
}
