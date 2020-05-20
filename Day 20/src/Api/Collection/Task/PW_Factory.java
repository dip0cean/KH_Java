package Api.Collection.Task;

import java.util.ArrayList;
import java.util.List;

public class PW_Factory {

	List<Character> secretNum = new ArrayList<Character>();

	protected PW_Factory() {

		// 대문자 데이터 추가
		for (char i = 65; i <= 90; i++) {
			secretNum.add(i);
		}

		// 소문자 데이터 추가
		for (char i = 97; i <= 122; i++) {
			secretNum.add(i);
		}

		// 숫자 데이터 추가
		for (char i = 48; i <= 57; i++) {
			secretNum.add(i);
		}
	}

	public int secretNumSize() {
		return secretNum.size();
	}

	public char secretNumGet(int i) {
		return secretNum.get(i);
	}
}
