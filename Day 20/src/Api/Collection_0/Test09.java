package Api.Collection_0;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test09 {
	public static void main(String[] args) {
//		준비물 : Scanner , List<String>

		Scanner sc = new Scanner(System.in);
		List<String> memory = new ArrayList<>();

		while (true) {
			System.out.print("사자성어 입력 \n > ");
			String word = sc.nextLine();

			if (!memory.contains(word) && word.length() == 4) {
				memory.add(word);
			} else {
				break;
			}

		}
		sc.close();
		System.out.println("\n<게임 오버>\n");

		for (String name : memory) {
			System.out.println("	-	" + name);
		}
	}
}
