package Api.Collection;

import java.util.ArrayList;
import java.util.List;

public class Test03 {
	public static void main(String[] args) {
//		Collection 은 Object 가 저장되는 저장소
//		<> 으로 인해 <> 안에 지정한 타입만 저장 가능 
//		> 내용물의 형식을 지정할 수 있는 방법을 Generic Type 이라고 한다
//		new 생성자는 리모콘의 형태 > 객체이기 때문에 <> 안에 지정 타입을 선언하지 않아도 됨
		List<String> a = new ArrayList<String>(); // 배열의 형태를 띈 List
		List<Integer> b = new ArrayList<Integer>();
		List<Boolean> c = new ArrayList<Boolean>();
		List<Double> d = new ArrayList<>();

//		추가 Method > .add()
//		a.add(100); // int
//		a.add(true); // boolean
//		a.add(1.5); // double

		a.add("hello"); // String

		b.add(100);
		b.add(50);

		c.add(true);
		c.add(false);
		c.add(true);
		c.add(false);

		d.add(0.6);
		d.add(1.5);
		d.add(7.2);

		System.out.println("a의 배열 : " + a);
		System.out.println("b의 배열 : " + b);
		System.out.println("c의 배열 : " + c);
		System.out.println("d의 배열 : " + d);
	}
}
