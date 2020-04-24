package Task;

import java.lang.*;
import java.util.Scanner;

public class Task03 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

//			입차 시간과 분		
		System.out.println("입차 시간을 입력해주세요.");
		int inHM = sc.nextInt();
		int inH = inHM / 100; // 입차 시간
		int inM = inHM % 100; // 입차 분

//			출차 시간과 분
		System.out.println("출차 시간을 입력해주세요.");
		int outHM = sc.nextInt();
		int outH = outHM / 100; // 출차 시간
		int outM = outHM % 100; // 출차 분
		sc.close();

//			이용 요금표
		int price = 1000; // freeTime+1부터 priceTime 당 요금
		int priceTime = 10; // 분 당
		int freeTime = 30; // freeTime분 만큼 무료
		int limitTime = 130; // limitTime분 이후 부터 무조건 10000원

//			출차 시간 - 입차 시간
		int inTime = (inH * 60) + inM; // 입차 시간
		int outTime = (outH * 60) + outM; // 출차 시간
		int sumTime = outTime - inTime; // 주차 시간
		boolean payMent = sumTime > freeTime && sumTime < limitTime; // 10000원 미만으로 결제 되는 시간의 범위

//			최종 요금		
		int tPrice;

		if (payMent && sumTime % priceTime != 0) {
			// 이용 시간 31분 부터 129분까지 그리고 이용시간의 10 나머지 값이 0이 아닐 경우

			tPrice = ((sumTime / priceTime) - (freeTime / priceTime - 1)) * price;

		} else if (payMent && sumTime % priceTime == 0) {
			// 이용 시간 31분 부터 129분까지 그리고 이용시간의 10 나머지 값이 0일 경우

			tPrice = (sumTime / priceTime - (freeTime / priceTime)) * price;

		} else if (sumTime <= freeTime) {
			// 이용 시간 30분 이하부터 무료

			tPrice = 0;

		} else {
			// 이용 요금이 10000원이 넘을 경우 요금은 10000원

			tPrice = 10000;

		}
		System.out.println("입차 시간 : " + inH + "시 " + inM + "분");
		System.out.println("출차 시간 : " + outH + "시 " + outM + "분");
		System.out.println("주차 시간 : " + sumTime + "분");
		System.out.println("결제 금액 : " + tPrice + "원");
	}

}
