package SwitchCase;

import java.util.Scanner;

public class SwitchTest02 {

	public static void main(String[] args) {
//		사용자에게 월을 정수로 입력 받아서 해당하는 월의 날짜수를 화면에 출력
//		ex) 2월 --> 2월은 28일까지 있습니다.

//		준비
		Scanner sc = new Scanner(System.in);
		
		System.out.println("월을 입력해주세요.");
		int month = sc.nextInt();
		sc.close();
		
		int day;
		switch(month) {
		// 28일 그룹
		case 2 :
			day = 28;
			
		// 30일 그룹	
		case 4 :
		case 6 :
		case 9 :
		case 11 :
			day = 30;
			break;
			
		// 31일 그룹	
		default :
			day = 31;
			break;
		}

//		출력
		System.out.println(month + "월은 "+day+"일까지 있습니다.");

	}

}
