package Task;

import java.lang.*;

public class Task01 {

	public static void main(String[] args) {
//		영화관 이용 요금
//		성인 : 10000원 / 청소년 : 7000원
//		성인 2명 / 청소년 3명이 영화를 보러가서 제휴카드로 25% 할인을 받았습니다. 
//		결제 금액을 구하세요. (10원과 1원 단위는 버립니다.)

//		입력
		int adult = 10000; // 성인 1인당 요금
		int boy = 7000; // 청소년 1인당 요금
		int aPeople = 2; // 성인 인원수
		int bPeople = 3; // 청소년 인원수
		double discount = 0.25; // 할인률 25%

//		계산
		int totalPrice = (adult * aPeople) + (boy * bPeople); // 할인전 총 결제 금액
		int discountPrice = (int) ((totalPrice - (totalPrice * discount)) / 100) * 100; // 총 결제 금액 - 할인 금액

//		결과
		System.out.println("할인 전 결제 금액 : " + totalPrice + " 원");
		System.out.println("할인 금액 : " + (int) (totalPrice * discount) + " 원");
		System.out.println("할인된 결제 금액 : " + discountPrice + "원");

	}

}
