package Api.Lang.String_2;

public class Test01 {
	public static void main(String[] args) {
//	문자열 검사 > 문자열은 글자가 나열되어 있는 배열
//	String == char[]		
//	- ??? 으로 시작하나요 > .startsWith()
//	- ??? 으로 끝나나요 > .endsWith()
//	- ??? 이 들어있나요 > .contains() / .indexOf()
//	- 길이는 얼마인가요 > .length()
//	- 문자열의 어느 위치에 있는 문자의 값을 알고 싶을 때 > .charAt()		

		String url = "http://www.naver.com";

		System.out.println(url.startsWith("http://"));
		System.out.println(url.startsWith("https://"));

		System.out.println(url.endsWith(".com"));
		System.out.println(url.endsWith(".net"));

		System.out.println(url.contains("naver"));
		System.out.println(url.indexOf("naver")); // .indexOf() 메소드는 문자의 위치를 찾아준다. > 문자의 시작위치를 알려줌

		System.out.println(url.length());

//		마지막 글자가 뭐에요..?
		// = 19번째에 뭐가 있나요?
		System.out.println(url.charAt(url.indexOf("m")));
	}
}
