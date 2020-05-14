package Api.Lang.etc;

import java.io.IOException;

public class Test03 {
	public static void main(String[] args) throws IOException {
//		Runtime 클래스
//		-	new 를 이용한 생성은 불가 / 생성 명령을 사용해야 함 (싱글톤)
//		-	종료하면서 다른 프로그램을 실행시키는 등의 작업을 수행할 수 있다.
		
//		Runtime r = new Runtime();		
		Runtime r = Runtime.getRuntime();
		r.exec("notepad");
		r.exec("calc");
		r.exec("mspaint");
//		r.exec("start http://www.naver.com");	//	권한 부족
		r.exec("cmd /c start http://www.naver.com");	//	커맨드의 /c 에서 웹사이트 주소를 실행해라
	}
}
