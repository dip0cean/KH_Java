package Api.Collection.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Test02 {

	public static void main(String[] args) {
		//	생성자 선언
		Random r = new Random();
		List<Integer> randomNum = new ArrayList<Integer>();
		StringBuffer pw = new StringBuffer();
		PW_Factory a = new PW_Factory();

		// 랜덤 섞기 + 똑같은 인덱스 번호 나오면 다시
		for (int i = 0; i < 10; i++) {
			int b = r.nextInt(a.secretNumSize());
			if (!randomNum.contains(b)) {
				randomNum.add(b);
			} else {
				i--;
			}
		}
		
		//	pw 에 secretNum 데이터 넣기
		for (int i = 0; i < randomNum.size(); i++) {
			pw.append(a.secretNumGet(randomNum.get(i)));
		}
		System.out.println("임시 비밀번호 : " + pw);

	}
	
}
