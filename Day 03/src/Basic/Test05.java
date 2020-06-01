package Basic;

public class Test05 {
	public static void main(String[] args) {
		/*
		 * 전체 결제 금액과 1인당 얼마인지 출력 소주 4000원 / 맥주 5000원 / 회식 인원 7명
		 */

//		준비		
		int soju = 4000; // 소주 1병 가격
		int beer = 5000; // 맥주 1병 가격
		int person = 7; // 인원수
		int sojuCount = 20; // 소주 마신 총 병수
		int beerCount = 15; // 맥주 마신 총 병수

//		계산
		int totalPrice = (soju * sojuCount) + (beer * beerCount); // 총 금액
		double personPrice = (double) totalPrice / person; // 1인당 지출 금액

//		출력		
		System.out.println("총 금액 : " + totalPrice + "원"); // 총 금액
		System.out.println("1인당 금액 : " + personPrice + "원"); // 1인당 지출 금액
	}
}
