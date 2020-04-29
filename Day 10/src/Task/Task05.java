package Task;

import java.lang.*;

public class Task05 {

	public static void main(String[] args) {
//		배열의 위치를 가지고 할 수 있는 작업
//		 배열의 x번 위치랑 y번 위치의 데이터를 바꿔라.

		int[] data = new int[] { 3, 5, 2, 1, 4 };
		
//		data[0] 과 data[3]을 바꾼다.
//		data[3] = data[0];
//		data[0] = data[3];
//		정상적인 코드는 임시 변수를 하나 만들어서 돌려막기로 대입
		int tmp = data[3]; // 임시 저장소
		data[3] = data[0]; // 1 -> 3
		data[0] = tmp; // 3 -> 1
		
//		출력
		for(int i =0; i < data.length; i++) {
			System.out.println(data[i]);
		}
	}

}
