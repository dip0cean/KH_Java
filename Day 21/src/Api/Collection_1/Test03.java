package Api.Collection_1;

import java.util.Set;
import java.util.TreeSet;

public class Test03 {

	public static void main(String[] args) {
		Set<String> study = new TreeSet<String>();

		study.add("String");
		study.add("반복문");
		study.add("조건문");
		study.add("반복문");
		study.add("배열");

		System.out.println(study);

		// Set 에서는 index 접근은 불가능하고 전체 처리만 가능하다. > 확장 반복문만 사용가능
		for (String name : study) {
			System.out.println(name);
		}

	}
}
