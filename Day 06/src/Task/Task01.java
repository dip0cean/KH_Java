package Task;

import java.lang.*;
import java.util.Calendar;
import java.util.Scanner;

public class Task01 {

	public static void main(String[] args) {
//		지하철 카드 발급 프로그램
//		사용자에게 생년 4자리를 입력 받아 일회용 지하철 카드를 발급
//		1) 어르신 (age >= 65) : 0원
//		2) 성인 (20 <= age <= 64) : 1250원
//		3) 어린이 (8 <= age <= 13) : 450원
//		4) 유아 (age <= 7) :0원
//		카드 보증금은 500원이고 사용자가 정보를 입력하면 요금을 계산하여 출력하세요.
		Scanner sc = new Scanner(System.in);

//		출생년도 입력		
		System.out.println("출생년도를 입력하세요.");
		int birth = sc.nextInt();

//		올해		
		int year = Calendar.getInstance().get(Calendar.YEAR);

//		나이 연산
		int age = (year - birth) + 1;

//		카드 보증금
		int card = 500;

//		연령별
		int price;
		String ageGroup;
		sc.close();

		if (age >= 65 || age <= 7) { // 어르신
			ageGroup = "어르신";
			if (age <= 7) {
				ageGroup = "유아";
			}
			price = 0;
		} else if (20 <= age) { // 성인
			ageGroup = "성인";
			price = 1250;
		} else if (14 <= age) { // 청소년
			ageGroup = "청소년";
			price = 720;
		} else { // 어린이
			ageGroup = "어린이";
			price = 450;
		}

		System.out.println(ageGroup + " 요금은 " + price + "원 입니다.");
		System.out.println("카드 발급까지 하시면 " + (price + card) + "원 입니다.");
	}

}
