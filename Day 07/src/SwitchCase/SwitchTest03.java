package SwitchCase;

import java.lang.*;
import java.util.Scanner;

public class SwitchTest03 {

	public static void main(String[] args) {
//		사용자에게 닉네임을 입력받고 입력받은 닉네임이 "운영자"인지 검사
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("사용하실 닉네임을 입력해주세요.");
		String user = sc.next();
		sc.close();

		
//		if문으로 이용하는 방법 > String 비교문 .equals()
		if(user.equals("운영자")) {
			System.out.println("사용할 수 없는 닉네임입니다.");
		} else {
			System.out.println("사용가능한 닉네임입니다.");
		}
		
		
//		switch ~ case 문으로 이용하는 방법
		switch(user) {
		
		case "운영자" :
			System.out.println("사용할 수 없는 닉네임입니다.");
			break;
		default :
			System.out.println("사용가능한 닉네임입니다.");
			break;
		}

	}

}
