package Basic;


public class Test09 {
	public static void main(String[] args) {
		//30분당 1000원
		//~ 29분 1000원
		//~ 59분	2000원
		//당구장을 3시간 35분 이용할 경우 요금
		
		int i = 1000;
		int hour = 60;
		int time = 3 * hour + 35;
		int result = time/30 * i + i; // + i 를 하는 이유는 정각 땡 하면 30분 요금이 추가되기 때문이다.
		System.out.println("총 이용 시간 : " + time + " 분");
		System.out.println("결제 금액 : " + result + " 원");
		
		/*	
		int hour = 3;
		int minute = 35;
		int Pay = 1000;
		int totalPay;
		
		
		if(minute <= 30) {
			
			Pay = 1000;
			totalPay = (hour*Pay*2) + Pay;
			System.out.println(totalPay);
			
		} else if(minute <= 59) {
			
			Pay = 2000;
			totalPay = (hour*Pay) + Pay;
			System.out.println(totalPay);
			
		}
		 */
	}
}
