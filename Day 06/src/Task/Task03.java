package Task;

import java.lang.*;

public class Task03 {

	public static void main(String[] args) {
//		주차장 요금 정산 프로그램
//		사용자에게 진입시간, 진출시간을 입력받아 다음 규칙에 따라 요금을 계산하여 출력하시오.
//		1) 30분까지는 주차요금 무료
//		2) 31분 부터 10분에 1000원
//		3) 아무리 오래 주차해도 일 최대 요금은 만원

		int inHour = 10; // 진입 시
		int inMinute = 00; // 진입 분
		int outHour = 10; // 진출 시
		int outMinute = 33; // 진출 분
		
		int startTime = 30; //30분 이후 부터 결제 시작
		int price = 1000; // freePrice 분당 가격
		int freePrice = 10; // 10분 당 
		
		int freeMoney = (startTime/freePrice) * price;
		
		int inTime = (inHour*60)+inMinute; // 진입한 시간
		int outTime = (outHour*60)+outMinute; // 진출한 시간
		int sumTime = outTime - inTime; // 할인 전 총 사용 분
		int tPrice = (sumTime/freePrice) * price;
		
		
		if(sumTime >= 31) {
			tPrice = tPrice;
			if (tPrice >10000) {
				tPrice = 10000;
			}
		} else {
			tPrice = 0;
		}
		

		System.out.println(sumTime);
		System.out.println(tPrice);

	}

}
