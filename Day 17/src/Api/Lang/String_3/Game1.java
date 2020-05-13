package Api.Lang.String_3;

import java.util.Scanner;

public class Game1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String start = "바나나";
		System.out.println("제시어 : > " + start);
		while (true) {
			String answer = sc.nextLine();

			char a = start.charAt(start.length() - 1);
			char b = answer.charAt(start.length() - 2);
			int c = start.length();
			int d = answer.length();

			if (a == b && c == d) {
				start = answer;
				System.out.println("\n다음 제시어를 입력하세요.");
			} else {
				sc.close();
				System.out.println("\n게임이 종료되었습니다.");
				break;
			}

		}

	}
}
