package Task;

import java.lang.*;

public class Task03 {

	public static void main(String[] args) {
//		주차장 요금 정산 프로그램
//		사용자에게 진입시간, 진출시간을 입력받아 다음 규칙에 따라 요금을 계산하여 출력하시오.
//		1) 30분까지는 주차요금 무료
//		2) 31분 부터 10분에 1000원
//		3) 아무리 오래 주차해도 일 최대 요금은 만원
		
		Scanner sc = new Scanner(System.in);
		
		int inHour = sc.nextInt(); // 진입 시
		int inMinute = sc.nextInt();; // 진입 분
		int outHour = 10; // 진출 시
		int outMinute = 30; // 진출 분

		int inTime = (inHour * 60) + inMinute; // 진입한 시간
		int outTime = (outHour * 60) + outMinute; // 진출한 시간
		int sumTime = outTime - inTime; // 할인 전 총 사용 시간

		int price;

		if (sumTime > 30 && sumTime < 130) { 
			price = ((sumTime / 10 - 2) * 1000); // 30분 이후 출차
		} else if (sumTime <= 30) {
			price = 0; // 30분 이전 출차
		} else {
			price = 10000; // 결제 금액 10000원 넘으면
		}
		System.out.println("주차 시간 : " + sumTime + "분 입니다.");
		System.out.println("결제 금액은 "+ price + "원 입니다.");
	}

}
