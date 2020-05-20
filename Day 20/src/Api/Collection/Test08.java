package Api.Collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test08 {
	public static void main(String[] args) {
//		사자성어 게임
//		사용자에게 사자성어를 입력 받은 뒤 저장소에 저장
//		이미 입력했던 내용을 다시 입력한다면 게임 오버처리
//		단, 게임 오버시 그 동안 입력했던 모든 사자성어 순서대로 출력

		Scanner sc = new Scanner(System.in);
		List<String> game = new ArrayList<>();
		while (true) {
			String a = sc.nextLine();
			if (!game.contains(a) && a.length() == 4) {
				System.out.println("다음 사자성어를 입력해주세요");
				game.add(a);
			} else if (a.length() != 4) {
				System.out.println("4자리를 초과했습니다.");
				sc.close();
				break;
			} else {
				sc.close();
				break;
			}
		}
		System.out.println("\n게임 오버\n");
		System.out.println("입력한 사자성어 > ");
		for (String name : game) {

			System.out.println(name);
		}
	}
}
