package Api.IO.Task;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test01 {

	public static void main(String[] args) throws IOException {
//		파일 복사 붙여넣기

		File readFile = new File("C:\\Users\\user\\Desktop\\15차후기.zip");
		FileInputStream in = new FileInputStream(readFile);

		File writeFile = new File("C:\\Users\\user\\Desktop\\copy2.zip");
		FileOutputStream out = new FileOutputStream(writeFile);

		// 배열 길이
		int bufferLength = 1000000;

		byte[] buffer = new byte[bufferLength];

		while (true) {
			int n = in.read(buffer);

			if (n == bufferLength) {
				out.write(buffer);
			} else if (n < bufferLength && n > -1) {
				out.write(buffer, 0, n);
			} else {
				break;
			}
		}
		in.close();
		out.close();

	}
}
