package Basic;


public class Test04 {
	public static void main(String[] args) {
		
		int dailyPrice = 8000; 	// 독서실 하루 이용료
		int term = 30; 			// 한달 30일
		int sale = 5000; 			// 1개월 이용 구독 시 5000원 할인
		
		int Price = dailyPrice * term; 		// 1개월 구독료
		
		System.out.println(Price); 			// 할인 전
		System.out.println(Price - sale); // 할인 후 
		
	}
}
