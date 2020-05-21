package Api.Collection_1;

import java.util.Set;
import java.util.TreeSet;

public class Test01 {

	public static void main(String[] args) {
//		Set <E> : 순서가 정해져 있는 저장소 (순서가 무시되는 저장소)
//		-	ex ) 전화번호부는 어떤 순서로 등록하던 가나다순으로 저장
//		-	전체를 빠르게 조회하고 싶을 때 사용하는 비선형 구조 (데이터를 넣을 때 에너지를 많이 소모한다.)
//		-	index가 없기 때문에 관련 명령이 존재하지 않음. (get() X)
//		-	중복 구분이 불가능하여 추가가 안된다.		

//		Set<Integer> s = new HashSet<Integer>(); // s 라는 저장소는 Hash 방식을 사용하는 Set 저장소이다.
		Set<Integer> s = new TreeSet<>(); // s 라는 저장소는 Tree 방식을 사용하는 Set 저장소이다.

		// 추가 : add()
		s.add(3);
		s.add(5);
		s.add(1);
		s.add(4);
		s.add(2);

		// 개수 확인 : size();
		System.out.println(s.size());

		// 5 가 저장소에 있나요? : contains();
		System.out.println(s.contains(5));
		System.out.println(s.remove(3)); // index 번호가 아닌 데이터가 3인 것을 지우세요

		System.out.println(s);
	}
}
