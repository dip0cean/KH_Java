package Basic;

import java.util.Calendar;


public class Test07 {
	public static void main(String[] args) {
		// 생년월일이 8자리 정수로 주어져 있다고 가정
		// 주어진 값을 이용하여 다음 항목들을 출력
		// 출생년도 / 월 / 일 / 나이(한국식)

// 생년월일 입력
		int b = 19990315;

// 생년
		int y = b / 10000; // 4자리를 버린 후 왼쪽 값
		System.out.println("생년 : " + y + " 년");

// 월
		int m = (b / 100) % 100; // 2자리 버린 후 오른쪽 2자리 값
		if (m < 10) {
			System.out.println("생월 : " + "0" + m + " 월");
		} else {
			System.out.println("생월 : " + m + " 월");
		}

// 일
		int d = b % 100; // 오른쪽 2자리 값 
		if (d < 10) {
			System.out.println("생일 : " + "0" + d + " 일");
		} else {
			System.out.println("생일 : " + d + " 일");
		}

// 나이
		int thisYear = Calendar.getInstance().get(Calendar.YEAR);
		int a = (thisYear - y) + 1;
		System.out.println("나이 : " + a + " 세");
	}

}
