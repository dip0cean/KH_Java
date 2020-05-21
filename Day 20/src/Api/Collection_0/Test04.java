package Api.Collection_0;

import java.util.ArrayList;
import java.util.List;

public class Test04 {
	public static void main(String[] args) {
//		List 의 다른 명령들

		List<Integer> list = new ArrayList<>();
		list.add(4);
		list.add(5);
		list.add(2);
		list.add(3);
		list.add(1);

		// 데이터를 지워볼까요?
		list.remove(4); // 오프젝트의 위치를 제거

		// 5가 있나요? > .contains(Object) > 논리형 메소드
		System.out.println(list.contains(5));

		// 데이터 개수 확인 > .size() > int 형 메소드 사용
		System.out.println(list.size());
		
		//	데이터 위치를 통한 값 확인
		System.out.println(list.get(0)); // ( ) 안의 인덱스 번호에 저장된 값이 뭔지 출력

		//	마지막 데이터 확인
		System.out.println(list.get(list.size() -1)); // .size 는 배열의 개수가 몇개인지
		System.out.println(list);
	}
}
