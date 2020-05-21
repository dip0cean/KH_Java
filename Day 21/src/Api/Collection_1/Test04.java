package Api.Collection_1;

import java.util.Set;
import java.util.TreeSet;

public class Test04 {

	public static void main(String[] args) {
//		데이터를 한 개씩 추가하는게 아니라 여러개를 추가할 수도 있을까?

		Set<String> yesterday = new TreeSet<String>();
		Set<String> today = new TreeSet<String>();

		yesterday.add("String");
		yesterday.add("반복문");
		yesterday.add("조건문");

		today.add("배열");
		today.add("반복문");

		Set<String> total = new TreeSet<String>();
		total.addAll(yesterday);
		total.addAll(today);
		System.out.println(total);
	}
}
