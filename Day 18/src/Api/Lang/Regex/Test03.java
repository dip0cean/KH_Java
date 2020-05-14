package Api.Lang.Regex;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Test03 {
	public static void main(String[] args) {
//		어떤 문자열이 ??? 형식인지 검사하세요
//		이름(닉네임)
//		생년월일
		Scanner sc = new Scanner(System.in);
		System.out.println("닉네임을 입력하세요. > ");
		String nick = sc.nextLine();
		String nickRegex = "^[가-힣]{3}$";
		System.out.println(Pattern.matches(nickRegex, nick));
		while (true) {
			System.out.println("생년월일을 입력하세요. > ");
			String birth = sc.nextLine();

			String birthRegex = "^([2][0]|[1][9])[0-9]{2}([\\-]|[.]|[ ])?((([0]?[13578]|[1][02])([\\-]|[.]|[ ])?([0]?[1-9]|[12][0-9]|[3][0-1]))|(([0]?[469]|[1][1])([\\-]|[.]|[ ])?([0]?[1-9]|[12][0-9]|[3][0]))|(([0]?[2])([\\-]|[.])?([0]?[1-9]|[1][0-9]|[2][0-8])))$";

			System.out.println(Pattern.matches(birthRegex, birth));
			if(Pattern.matches(birthRegex, birth)) {
				sc.close();
				break;
			}
		}
	}
}
