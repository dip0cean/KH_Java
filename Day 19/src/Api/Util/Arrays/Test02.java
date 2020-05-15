package Api.Util.Arrays;

import java.util.Arrays;

public class Test02 {
	public static void main(String[] args) {
		int[] data = new int[] { 3, 5, 4, 1, 2 };

		Arrays.sort(data); // 배열의 기본 정렬 알고리즘
		System.out.println(Arrays.toString(data));

//		<> = 제너릭
//		이 경우 참조형 자료형을 적어서 대상의 형태를 명시해준다.
// 		익명 중첩 클래스 > 현재 클래스에서만 사용하고 버려질 1회용 상속
//		Comparator<Integer> c = new Comparator<Integer>() {
//			public int compare(Integer o1, Integer o2) {
//				return 0;
//			}
//		}; // <제너릭>

		Arrays.sort(data);
		System.out.println(Arrays.toString(data));

	}
}
