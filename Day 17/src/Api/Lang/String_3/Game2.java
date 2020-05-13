package Api.Lang.String_3;

import java.util.Scanner;

public class Game2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String start = "바나나";
		while (true) {
			String answer = sc.nextLine();
			String a = Character.toString(start.charAt(start.length() - 1));
			String b = Character.toString(answer.charAt(answer.length() - 3));

			if (a.equals(b) && start.length() == answer.length()) {
				start = answer;
				String c = Character.toString(answer.charAt(answer.length() - 1));
				System.out.print(c + ">");
			} else {
				sc.close();
				System.out.println("게임"
						+ "ㅅ에서 패배했습니다.");
				break;
			}

		}

	}
}
