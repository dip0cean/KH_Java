package Api.IO.Single;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

public class Test05 {

	public static void main(String[] args) throws IOException {
//		한번에 여러개식 내보내고 불러오기
//		-	준비물 : 입력 파일 객체 / 입력 스트림 / 4개의 저장소 -> byte 배열

		File target = new File("single.txt");
		FileInputStream in = new FileInputStream(target);
//		[프로그램] < in < target < out < [파일]

		byte[] buffer = new byte[4];

//		buffer 에 저장할 수 있도록 데이터를 불러올 계획
		while (true) {
			int n = in.read(buffer);
			if (n == -1) {
				break;
			}
			System.out.println(Arrays.toString(buffer));
			System.out.println(n);
		}
		in.close();
	}
}
