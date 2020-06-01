package Basic;


public class Test03 {
	public static void main(String[] args) {
		//독서실 하루 이용료 8천원
		// 30일 이용권 구매시 5천원 할인
		// 1. 할인 전 금액을 구하여 화면에 출력
		// 2. 할인 후 금액을 구하여 화면에 출력
		
		int day = 8000;
		int month = day * 30;
		int sale = (day * 30) - 5000;
	
		System.out.println("할인 전 금액 : " + month + "원");
		System.out.println("할인 후 금액 : " + sale + "원");
		System.out.println("2개월 이용료 : " + (2*sale) + "원");
		System.out.println("3개월 이용료 : " + (3*sale) + "원");
		System.out.println("6개월 이용료 : " + (6*sale) + "원");
	}
}
