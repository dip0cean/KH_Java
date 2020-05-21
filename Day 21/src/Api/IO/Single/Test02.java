package Api.IO.Single;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Test02 {

	public static void main(String[] args) throws IOException, InterruptedException {
//		Single Byte 입력 > single.txt 의 내용을 불러와서 화면에 출력
//		-	준비물 : 파일 객체 , Input Stream

		File target = new File("single.txt");
		System.out.println(target.exists());

		FileInputStream a = new FileInputStream(target);
		while (true) {
			int n = a.read();
			if (n == -1)
				break;
			System.out.println("n = " + n);

			Thread.sleep(500L);

		}
		a.close();
	}
}
