package Api.Collection;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Test10 {

	public static void main(String[] args) {
//		List 는 "순서" 를 중요시 여기기 때문에 순서와 관련된 명령이 많다.
//		-	Collections 라는 Util Class 명령들이 존재		
//		-	순서대로 정렬
//		-	순서를 뒤집어라
//		-	순서를 뒤섞어라

		List<Integer> n = new LinkedList<Integer>(); // Up Casting
		for (int i = 1; i <= 10; i++) {
			n.add(i);
		}
		System.out.println(n);

		// Collections 클래스를 통해 배열을 뒤집기
		Collections.reverse(n);
		System.out.println(n);

		// Collections 클래스를 통해 배열을 뒤섞기
		Collections.shuffle(n);
		System.out.println(n);

		// Collections 클래스를 통해 배열을 정렬하기
		Collections.sort(n);
		System.out.println(n);
	}

}
