package Api.Collection_0;

import java.util.ArrayList;
import java.util.List;

public class Test02 {
	public static void main(String[] args) {
		List a = new ArrayList(); // 배열의 형태를 띈 List
//		List b = new CopyOnWriteArrayList(); // Blocking ArrayList (동기화 > 싱글 스레드)
//		List c = new LinkedList(); // 연결 형태의 List

//		추가 Method > .add()
//		Collection 은 Object 가 저장되는 저장소		
		a.add(100); // int
		a.add(true); // boolean
		a.add(1.5); // double
		a.add("hello"); // String

		System.out.println(a);
	}
}
