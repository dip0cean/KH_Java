package For;


public class Test02 {

	public static void main(String[] args) throws InterruptedException {
//		10부터 카운트다운을 수행하는 프로그램을 구현

		for (int i = 10; i > 0; i--) {
			System.out.println(i + " !");
			
			Thread.sleep(1000L); // 1초 휴식
		}
		System.out.println("Happy New Year!");
	}

}
