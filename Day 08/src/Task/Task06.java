package Task;

import java.lang.*;

public class Task06 {
	public static void main(String[] args) {
//		1부터 99까지 존재하는 5가 들어간 숫자의 개수를 세어서 출력

		int loop = 1; 						// 시작점
		int count = 0; 						// 5가 들어간 숫자의 개수
		int five, fifty; 						// 5가 들어간 숫자 골라내기

		System.out.println("'5' 가 포함된 숫자들 >");
		while (loop < 100) {
			five = loop % 10;
			fifty = loop / 10;
			if (five == 5 || fifty == 5) {
				count++;
				System.out.print(loop + "\t");
			}
			loop++;
		}
		System.out.println("\n" + "총 " + count + " 개");

	}

}
