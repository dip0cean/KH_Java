package Basic;


public class Test09_1 {

	public static void main(String[] args) {
		//당구장 문제 강사님 풀이
		//0~29분 (총 30분) 에 1000원
		// 반복의 규칙을 먼저 찾자
		//요금은 시간을 분으로 바꾸고 30으로 나누고 1000을 곱하고 1000을 더해야 함
		
//		준비 : 이용시간 , 이용요금
		int hour = 3 , minute = 35;
		int term = 30; // 기준시간(분)
		int price = 1000; // 기준요금(원)
		
//  	계산 : 이용시간 (분) , 요금
		int time = hour * 60 + minute;
		int pay = time / term * price + price;
		
//		결과
		System.out.println("결제 금액 : " + pay + " 원");
	}

}
