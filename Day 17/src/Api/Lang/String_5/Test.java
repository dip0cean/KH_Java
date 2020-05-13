package Api.Lang.String_5;

import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
//		사용자에게 채팅을 입력 받아 불필요한 단어를 제거한 뒤 출력하는 프로그램 구현
//		불필요한 단어 : 신발끈 ,개나리, 수박씨, 호루라기, 시베리아, 십장생, 조카, 주옥, 쌍쌍바, 십자수
//		-	불필요한 단어는 전부 *로 대체하시오.
//		-	단어수와 별 개수를 맞춰서 출력.

		Scanner sc = new Scanner(System.in);
		System.out.println("채팅을 입력하세요. > ");
		String a = sc.nextLine();
		sc.close();

		// 욕설 처리 머신의 메소드 호출 후 출력
		System.out.println(Fuck.filter(a));

	}
}
