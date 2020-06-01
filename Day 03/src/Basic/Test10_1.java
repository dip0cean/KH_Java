package Basic;


public class Test10_1 {

	public static void main(String[] args) {
		// 0~9분 무료 / 10~19분 500원
		// 규칙 -> /10

//		준비
		int inHour = 10 , inMinute = 45; // 들어온 시간
		int outHour = 17 , outMinute = 20; // 나간 시간
		
//		계산 : 진입시간(분), 진출시간(분), 주차시간(분), 주차요금(원)
		int inTime = inHour * 60 + inMinute;
		int outTime = outHour * 60 + outMinute;
		int time = outTime - inTime;
		int price = time / 10 * 500;
				
//		출력
		System.out.println("결제 요금 : " + price + " 원");
	}

}
