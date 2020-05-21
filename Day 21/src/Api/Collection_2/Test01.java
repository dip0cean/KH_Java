package Api.Collection_2;

import java.util.HashMap;
import java.util.Map;

public class Test01 {

	public static void main(String[] args) {
//		Map : Key - Value 저장소
//		-	Key - Value 는 아이디 / 비밀번호의 관계와 같은 경우를 말한다.
//		- 	Key 는 중복 불가 / Value 는 중복 가능		
//		-	순서가 유지되지 않음 > 무시된다.
//		-	ex ) 변수명 - 값, 아이디 - 비밀번호
		
		Map<String, Integer> memory = new HashMap<String, Integer>();
		
//		데이터 추가 : .put()		
		memory.put("b", 200);
		memory.put("a", 100);
		memory.put("c", 200);
		memory.put("c", 300);
		
//		데이터 개수 : .size()		
		System.out.println(memory.size());
		System.out.println(memory);
		
//		데이터 검색 : .contains() --> .containsKey() / .containsValue()	
		System.out.println(memory.containsKey("a"));
		System.out.println(memory.containsValue(100));
		
//		데이터 삭제 : .remove() --> 오직 Key만 삭제 가능
		memory.remove("a");
		System.out.println(memory);
	}
}
