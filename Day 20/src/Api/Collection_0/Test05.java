package Api.Collection_0;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Test05 {
	public static void main(String[] args) {
//		List 형태의 저장소를 만들어서 로또번호 6개를 저장한 뒤 출력
//		-	로또 번호는 1부터 45 사이의 정수 중 한개를 추첨합니다.

		Random r = new Random();
		List<Integer> lotto = new ArrayList<>();
		int index = 6;

		for (int i = 0; i < index; i++) {
			int a = r.nextInt(45) + 1;
			if (!lotto.contains(a)) {
				lotto.add(a);
			} else {
				i--;
			}

		}

		System.out.println(lotto);
	}
}
