package Basic;

import java.lang.*;

public class Test08_1 {
	public static void main(String[] args) {
		
		// 입력
		int yesHour = 3, yesMin = 20;
		int toHour = 2, toMin = 50;
		
		//계산
		//어제 공부한 시간(분), 오늘 공부한 시간(분), 합계, 차이
		int yesTime = (yesHour*60) + yesMin;
		int toTime = (toHour*60) + toMin;
		int totalTime = yesTime + toTime;
		int gap = yesTime - toTime;
		
		// 출력
		System.out.println("합계");
		System.out.println("총 " + (totalTime / 60) + "시간 " + totalTime % 60 + "분 공부했습니다.");
		
		System.out.println("차이");
		System.out.println("총 " + (gap / 60) + "시간 " + (gap % 60) + "분 차이납니다.");
		
	}
}
