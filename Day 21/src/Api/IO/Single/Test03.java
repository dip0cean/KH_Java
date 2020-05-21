package Api.IO.Single;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Test03 {

	public static void main(String[] args) throws IOException {
//		파일 복사를 다음 조건에 맞게 구현
//		-	프로젝트에 만들어준 single.txt를 copy.txt 라는 파일에 복사
//		-	두 파일은 동일한 내용을 가져야 함
//		-	프로그램이 실행되면 자동으로 복사가 완료되도록 구현

//		복사할 파일 불러오기		
		File target = new File("C:\\Users\\user1\\Downloads\\FAQ.hwp");
		
//		복사 할 데이터 받아쓰기		
		FileInputStream in = new FileInputStream(target);
		
//		List 인터페이스를 통해 int 타입 데이터 배열에 저장하기		
		List<Integer> contents = new ArrayList<Integer>();
		while (true) {
			int a = in.read();
			if (a == -1) {
				break;
			}
			contents.add(a);
		}
		in.close();
		System.out.println(contents);

//		받아 쓸 파일 만들기		
		File copy = new File("C:\\Users\\user1\\Downloads\\copy.hwp");
		copy.createNewFile();

//		받아 쓴 데이터 불러오기		
		FileOutputStream out = new FileOutputStream(copy);

//		List 인터페이스로 만든 배열 다시 받아쓰기		
		for (int i = 0; i < contents.size(); i++) {
			out.write(contents.get(i));
		}
		out.close();
	}
}
