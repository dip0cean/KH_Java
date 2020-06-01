package Task;

public class Task04 {
	public static void main(String[] args) {
//		30일 동안 다이어트를 위해서 푸시업을 할 계획입니다.
//		첫 날에는 너무 힘드니까(ㅋㅋ) 10개만 하고 다음날부터는 전날보다 3개씩 더 할 계획입니다.
//		1) 일자별로 하게되는 푸시업 개수를 구해서 출력
//		2) 30일동안 하게되는 푸시업 개수를 구해서 출력

		int day = 1; 					// 1일차부터
		int pushUp = 10; 			// 10개부터
		int total = 0;

		while (day <= 30) {
			System.out.println(day + "일 : " + pushUp + "개");

			total += pushUp;
			
			day++; 					// 하루에
			pushUp += 3; 			// 3개씩 더 할 것이다.
			
		}
		System.out.println();
		System.out.println("총 " + total + "개의 푸시업을 하면 됩니다.");
	}

}
