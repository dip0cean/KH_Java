package Api.IO.File;

import java.io.File;
import java.io.IOException;

public class Test02 {

	public static void main(String[] args) throws IOException {
//		자바에서는 파일/폴더를 만들거나 삭제할 수 있다.
//		-	운영체제에서 금지한 곳은 접근할 수 없다.

		File dir = new File("Files");
		System.out.println(dir.exists()); // 폴더 / 파일 존재 여부 확인

		dir.mkdirs(); // 폴더 생성 명령
		dir.delete(); // 폴더 삭제

		dir.createNewFile(); // 파일 생성 명령
		dir.delete(); // 파일 삭제

		File txt = new File("Hello");
		System.out.println(txt.exists());
		txt.mkdirs();
		txt.delete();
	}
}
