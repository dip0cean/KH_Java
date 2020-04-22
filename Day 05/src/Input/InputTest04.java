package Input;

import java.lang.*;
import java.util.*;

public class InputTest04 {

	public static void main(String[] args) {
//		Scanner 도구를 이용한 문자열 입력
//		- 단어 입력 : 어떠한 공백(스페이스, 엔터)을 기준으로 구분
//		- 문장 입력 : 엔터를 기준으로 구분

//		Scanner 도구 생성		
		Scanner sc = new Scanner(System.in);

		System.out.println("이름을 입력하세요. > ");
//		 단어 입력 구분 : 공백을 기준
		String a = sc.next();
		System.out.println("입력하신 이름은 " + a + "입니다." + "\n");

//		\n 값을 버리는 용도		
		sc.nextLine();
		System.out.println("문장을 입력하세요. > ");

//		 문자 입력 구분 :엔터를 기준		
		String b = sc.nextLine();
		System.out.println("입력하신 문장은 " + b + "입니다.");

		sc.close();

		/*
		 * 왜 중간에 \n 값을 버리는 용도로 nextLine() 메소드를 사용하는가? next() 메소드는 공백을 기준으로 구분되기 때문에 단어를
		 * 입력하고 엔터를 입력하면 엔터가 nextLine() 메소드에 입력되어 조건을 충족했기 때문에 실행문을 종료한다. 그렇기 때문에
		 * nextLine() 메소드를 중간에 한번 더 사용해줘 단어 입력 후 엔터를 대신 잡아갈 수 있도록 하면 다음 실행문인 nextLine()
		 * 메소드도 사용 가능하다.
		 */

//		next() 			메소드는 콩백을 만나면 그 앞에 있는 글자를 가져오고 끝		
//		nextLine() 		메소드는 엔터를 만나면 그 앞에 있는 글자를 가져오고 뒤에 있는 엔터를 버린다.

	}

}
