package Basic;


public class Test10 {

	public static void main(String[] args) {
		// 10분에 500원
		// 10 ~ 19 분까지는 500원
		// 20분이 되는 시점 부터 1000원
		// 10시 45분에 들어와서 17시 20분에 나갔으면 얼마를 내야하는가

		int hour = 60;
		int in = 10 * hour + 45;
		int out = 17 * hour + 20;
		int pay = 500;

		int result = (out - in) / 10 * pay;

		System.out.println(result);
	}

}
