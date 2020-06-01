package Task;

import java.util.Random;
import java.util.Scanner;

public class Task01 {

	public static void main(String[] args) {
//		사용자에게 연도를 입력받아 해당하는 연도의 무작위 날짜 1개를 출력
//		윤년일 경우 2월은 29일까지 있고, 윤년이 아닐 경우 2월 28일까지 있습니다.
		Scanner sc = new Scanner(System.in);
		Random r = new Random();

//		년도 입력	
		System.out.println("년도를 입력해주세요.");
		int year = sc.nextInt();
		sc.close();

//		윤년 검사		
		boolean a = year % 400 == 0;
		boolean b = year % 100 != 0;
		boolean c = (a || b) && (year % 4 == 0);
		String str; // 윤년인지 아닌지
		
//		랜덤으로 월 지정받기		
		int month = r.nextInt(12) + 1;
		int day;

//		윤년일 경우와 아닐 경우
		if (c) {
			// 윤년일 경우 월의 값에 따라 일자가 랜덤으로 지정
			switch (month) {
			case 2:
				day = r.nextInt(29) + 1;
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				day = r.nextInt(30) + 1;
				break;
			default:
				day = r.nextInt(31) + 1;
				break;
			}
			str = "윤년입니다.";
		} else {
			switch (month) {
			// 윤년이 아닐 경우 월의 값에 따라 일자가 랜덤으로 지정
			case 2:
				day = r.nextInt(28) + 1;
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				day = r.nextInt(30) + 1;
				break;
			default:
				day = r.nextInt(31) + 1;
				break;
			}
			str = "윤년이 아닙니다.";
		}
		
//		출력
		System.out.println("윤년인가요? \n" + str);
		System.out.println(year + "년 " + month + "월 " + day + "일");
	}

}
