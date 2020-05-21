package Api.IO.Single;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test06 {

	public static void main(String[] args) throws IOException {
//		버퍼를 이용해서 여러개를 한 번에 출력
//		-	준비물 : 출력용 파일 객체 , 스트림 / Buffer(byte size : 5)

		File target = new File("test.txt");
		FileOutputStream out = new FileOutputStream(target);

		byte[] buffer = new byte[] { 104, 101, 108, 108, 111 };

//		out을 이용해서 buffer 에 들어있는 데이터를 원하는 만큼 출력
		out.write(buffer); // buffer의 전체
		out.write(buffer, 0, 4); // 0 ~ 4 번 인덱스의 데이터만
		out.close();
	}
}
