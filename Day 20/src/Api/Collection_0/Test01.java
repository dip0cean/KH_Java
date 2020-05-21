package Api.Collection_0;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Test01 {
	public static void main(String[] args) {
//		Set / List
//		Set > 특정 방식에 의해 분류되는 저장소
//		List > 순서가 중요한 저장소

		// Set / List 생성자 선언 불가능 > 인터페이스이기 때문이다.
//		Set a = new Set();
//		List b = new List();
		Set a = new TreeSet(); // ex) 전화번호부 > 차순대로 정렬 > 입력 순서 무시 > 중복 X
		List b = new ArrayList(); // ex) 통화목록 > 입력 순서대로 > 중복 O

		//	a  / b 저장소에 "이 름" 을 추가하라.
		a.add("심성헌"); 
		b.add("심성헌");
		
		a.add("최하은");
		b.add("최하은");
		
		a.add("김애옹");
		b.add("김애옹");
		
		a.add("심또익");
		b.add("심또익");
		
		a.add("심꼬망");
		b.add("심꼬망");
		
		a.add("심꼬망");
		b.add("심꼬망");

		System.out.println(a);
		System.out.println(b);
	}
}
