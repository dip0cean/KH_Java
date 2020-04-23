package Condition;

import java.lang.*;
import java.util.Scanner;

public class Test04 {

	public static void main(String[] args) {
//		여행사 결제 프로그램
//		사용자에게 여행가고 싶은 달을 숫자로 입력 받아서 예상 할인율을 보여주는 프로그램 구현
//		할인율은 계절마다 다르며 다음과 같다.
//		1) 봄 : 20%
//		2) 여름 : 0%
//		3) 가을 : 5% 
//		4) 겨울 : 30%
		Scanner sc = new Scanner(System.in);

		while (true) {
//			월 입력			
			System.out.println("날짜를 입력해주세요. > ");
			int month = sc.nextInt();

//		월 별 계절 비교		
			boolean spring = 3 <= month && 5 >= month; // 봄(3~5월)
			boolean summer = 6 <= month && 8 >= month; // 여름(6~8월)
			boolean autumn = 9 <= month && 11 >= month; // 가을(9~11월)
			boolean winter = 12 == month || (1 <= month && 2 >= month); // 겨울(12~2월)

//		입력값에 따른 출력

			if (spring) {
				System.out.println(month + "월의 할인율은 20% 입니다.");
				break;
			} else if (summer) {
				System.out.println(month + "월의 할인율은 0% 입니다.");
				break;
			} else if (autumn) {
				System.out.println(month + "월의 할인율은 5% 입니다.");
				break;
			} else if (winter) {
				System.out.println(month + "월의 할인율은 30% 입니다.");
				break;
			} else {
				System.out.println("날짜를 잘못 입력하셨습니다. 다시 입력해주세요.\n");
			}

		}

	}

}
