package Api.Collection.Task;

import java.util.Random;

public class Test01 {

	public static void main(String[] args) {
//		임시 비밀번호 발급
//		문자 중복 버전

		PW_Factory a = new PW_Factory();
		Random r = new Random();

		// StringBuffer 에 랜덤으로 데이터 추가
		StringBuffer pw = new StringBuffer();
		for (int i = 0; i < 10; i++) {
			char data = a.secretNumGet(r.nextInt(a.secretNumSize()));
			pw.append(data);
		}
		System.out.println("임시 비밀번호 :  " + pw);

	}

}
