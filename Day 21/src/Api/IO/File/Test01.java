package Api.IO.File;

import java.io.File;

public class Test01 {
	public static void main(String[] args) {
//		File I/O > File을 입/출력하는 개념
//		-	파일 (File)
//		-	입출력 (I/O)

//		제어할 수 있는 리모컨 생성
//		이름을 잘못 써도 만들어지기 때문에 "있냐 / 없냐" 가 매우 중요함 
		File a = new File("Hello.txt");
		System.out.println("a가 실존하는 파일입니까? " + a.exists()); // 파일 실존 여부 확인 메소드

//		자바는 파일과 폴더를 구분하지 않고 모두 File 클래스로 관리
//		파일일 때와 폴더일 때를 구분하여 사용하는 명령이 필요
		System.out.println("a는 파일입니까? " + a.isFile());
		System.out.println("a는 폴더입니까? " + a.isDirectory());

//		본격적인 파일 정보를 탐색
//		-	정보를 가져와야 하므로 getter 메소드를 이용
		System.out.println("파일 이름 : " + a.getName()); // 파일 이름
		System.out.println("파일 절대 경로 : " + a.getAbsolutePath()); // 파일의 절대 경로
		System.out.println("파일 상대 경로 : " + a.getPath()); // 파일의 상대 경로
		System.out.println("파일 크기 : " + a.length()); // 파일의 크기 (byte) > 롱으로 표현됨
		System.out.println("최종 수정 시간 : " + a.lastModified()); // 최송 수정 시각(ms) > System.currentTimeMillis()
		System.out.println("숨김 파일인가 ? : " + a.isHidden()); // 숨김 파일인지 아닌지
		System.out.println("읽기 전용인가 ? : " + a.setReadOnly()); // 읽기 전용 파일인지 아닌지

	}
}
