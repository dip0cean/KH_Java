package Task;

import java.lang.*;
import java.util.Random;

public class Task06_2 {

//		데이터를 배열에 저장하고 주어진 문제에 맞게 위치를 조작하여 출력
//		Q2 >  데이터의 순서를 무작위로 바꾸어 출력
//			- 모든 자리가 자기 자신을 제외한 다른 자리와 한번 이상 바뀌어야 한다.

	public static void main(String[] args) {
		Random r = new Random();

		String[] name = new String[] { "Java", "JavaScript", "Python", "Ruby", "C#" };
		String a; // 임시 저장소
		int k; // 랜덤 변수

		for (int i = 0; i < name.length; i++) {
			while (true) {
				k = r.nextInt(name.length);

				a = name[i];
				name[i] = name[k];
				name[k] = a;
				
// 				i 와 k 가 같으면 중복이니 while의 처음으로 돌아가 반복하고, i 와 k 가 다르면 while 문을 멈춰라
				if (i != k) {
					break;
				}
			}
		}

		for (int i = 0; i < name.length; i++) {
			System.out.println("name[" + i + "] = " + name[i]);
		}
		
	}

}
