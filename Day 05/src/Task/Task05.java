package Task;

import java.util.Scanner;

public class Task05 {

	public static void main(String[] args) {
//		1시간 요금 : 1000원
//		혜택 : 1시간 충전 시 10분 추가 (ex. 1시간 > 1시간 10분)
//		입력값 : 충전 금액 , 충전 시간
//		출력 : 실제 충전된 시간 / 거스름돈 (단, 돈을 부족하게 투입하는 경우 없음)

//		Scanner 도구 선언		
		Scanner sc = new Scanner(System.in);

//		시간 당 요금		
		int hourPrice = 1000; // 시간당 이용금액
		int hour = 70; // 1시간 충전 시 10분 추가

//		충전 금액 입력		
		System.out.println("충전 금액을 입력해주세요. >");
		int inMoney = sc.nextInt(); // 충전 금액

//		충전 시간 입력		
		System.out.println("충전 시간을 입력해주세요. >");
		int inHour = sc.nextInt(); // 충전 시간

//		충전된 시간과 거스름돈 연산		
		int outMoney = inMoney - (hourPrice * inHour); // 거스름돈
		int totalTime = (inHour * hour); // 충전된 시간

//		결과값 출력
		System.out.println("충전된 시간 : " + (totalTime / 60) + "시간" + (totalTime % 60) + "분");
		System.out.println("거스름돈 : " + outMoney + "원");

		sc.close();
	}

}
