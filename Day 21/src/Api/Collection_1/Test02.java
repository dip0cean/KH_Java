package Api.Collection_1;

import java.util.Set;
import java.util.TreeSet;

public class Test02 {

	public static void main(String[] args) {
//		다음은 어제와 오늘 내가 공부한 자바의 용어들입니다.
//		-	어제 : String, 반복문, 조건문
//		-	오늘 : 배열. 반복문
//		어제와 오늘 공부한 용어들을 겹치는 것은 한번만 나오도록 출력해보세요.

		Set<String> yStudy = new TreeSet<String>();
		yStudy.add("String");
		yStudy.add("반복문");
		yStudy.add("조건문");

		Set<String> tStudy = new TreeSet<String>();
		tStudy.add("배열");
		tStudy.add("반복문");

		Set<String> a = new TreeSet<String>();
			a.addAll(tStudy);
			a.addAll(yStudy);

		System.out.println(a);
	}

}
