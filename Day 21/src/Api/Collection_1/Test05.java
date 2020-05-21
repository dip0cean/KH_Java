package Api.Collection_1;

import java.util.HashSet;
import java.util.Set;

public class Test05 {

	public static void main(String[] args) {
//		HashSet : 해시 알고리즘을 사용하는 Set 저장소
		Set<Integer> s = new HashSet<Integer>();
		
		s.add(300000);
		s.add(200);
		s.add(455);
		s.add(500);
		s.add(784);
		
		System.out.println(s);
		
//		전체 명령은 동일하지만 TreeSet 등의 구조가 다르다는 것을 유의!		
	}

}
