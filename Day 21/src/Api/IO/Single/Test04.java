package Api.IO.Single;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test04 {

	public static void main(String[] args) throws IOException {
//		파일 복사 문자
//		-	복사 : 입력 후 출력
//		- 	준비물 : 입력용 파일 객체 , 통로 / 출력용 파일 객체, 통로

		File readFile = new File("single.txt");
		FileInputStream in = new FileInputStream(readFile);

		File writeFile = new File("copy2.txt");
		FileOutputStream out = new FileOutputStream(writeFile);

		long count = 0L;

		while (true) {
			int n = in.read();
			if (n == -1) {
				break;
			}
			out.write(n);
			count++;
			System.out.println(count + " / " + readFile.length());
		}
		in.close();
		out.close();
	}
}
