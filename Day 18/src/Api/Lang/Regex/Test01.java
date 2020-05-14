package Api.Lang.Regex;

import java.util.regex.Pattern;

public class Test01 {
	public static void main(String[] args) {
//		정규 표현식(Regular Expression)을 이용한 전화번호 검사
//		-	java.util.regex.Pattern
		
		String phone = "010-1234-5679";
		String regex = "^01[016-9](-?[0-9]{4}){2}";
		
		System.out.println(Pattern.matches(regex, phone));

	}
}
