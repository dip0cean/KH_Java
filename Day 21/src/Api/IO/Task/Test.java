package Api.IO.Task;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test {

	public static void main(String[] args) throws IOException {
//		파일 복사 붙여넣기

		File readFile = new File("C:\\Users\\user1\\Desktop\\sqldeveloper-18.4.0-376.1900-x64.zip");
		FileInputStream in = new FileInputStream(readFile);

		byte[] buffer = new byte[1000000];

		File writeFile = new File("C:\\Users\\user1\\Desktop\\test.zip");
		FileOutputStream out = new FileOutputStream(writeFile);

		long count = 0L;
		while (true) {
			int n = in.read(buffer);
			count++;
			if (n == -1) {
				break;
			}
			out.write(buffer);
		}
		System.out.println(count);
		in.close();
		out.close();

	}
}
