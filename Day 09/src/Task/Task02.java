package Task;

import java.lang.*;

public class Task02 {

	public static void main(String[] args) {
		/*
		 * 고대 그리스에 아주 현명한 노인이 있었습니다. 왕이 그 노인에게 "원하는 걸 선물해줄테니 말해봐라" 라고 했습니다.
		 * 
		 * 노인이 말하길
		 * 
		 * "저는 별로 바라는게 없습니다. 첫날 1원만 주시고, 둘째 날부터 전날의 두배만 주시면 됩니다. "
		 * 
		 * 40일 동안 이 노인이 받게 되는 돈의 액수와 총 얼마 받는지 계산하여 출력
		 */
		
		long coin = 1L;
		long sum = 0L;
		for(long i = coin; i <= 40; i++) {
			System.out.println(i + "일 : " + coin + "원");
			sum += coin;
			coin *= 2;
			System.out.println("합계 : " + sum + "원 \n");
		}
		System.out.println("총 " + sum + "원");
	}

}
