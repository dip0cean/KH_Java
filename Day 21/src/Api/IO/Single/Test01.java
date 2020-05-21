package Api.IO.Single;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test01 {

	public static void main(String[] args) throws IOException {
//		Single Byte 출력
//		연결할 대상이 2개 있어야 한다.		
//		-	준비 : 파일 객체 , 출력 스트림		
//		1.	파일 만들기		

//		if (!target.exists()) { // 파일이 없으면
//			target.createNewFile(); // target 파일을 생성해라
//		}
//		현재 target은 없지만 존재하지 않아도 저장하면 자동 생성됨 > 직접 생성 X		
//		프로그램 > out > target > 실제 파일

//		out 에게 데이터를 전달하면 자동으로 파일까지 전달된다.
		File target = new File("single.txt");
		FileOutputStream out = new FileOutputStream(target);
//		int 타입이여도 byte 범위를 벗어나면 안된다.
		out.write(65); 
		out.write(66);
		out.write(9);
		out.write(104);
		out.write(101);
		out.write(108);
		out.write(108);
		out.write(111);
		out.write(10);
		out.close();
	}

}
