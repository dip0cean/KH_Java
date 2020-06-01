package Basic;


public class Test08 {
	public static void main(String[] args) {
		//어제는 3시간 20분 공부하고, 오늘은 2시간 50분 공부했습니다.
		//다음을 계산하여 출력하세요

		//어제 공부한 시간과 오늘 공부한 시간의 합계 시간
		//어제 공부한 시간과 오늘 공부한 시간의 차이
		
		//60진수를 이용해야 함
		
		int yesterday = (3*60) + 20;
		int today = (2*60) + 50;
		
		int sumHour = (yesterday + today)/60;
		int sumMinute = (yesterday + today)%60;
		int minus = yesterday - today;
		
		System.out.println(sumHour + "시간" + sumMinute + "분");
		System.out.println(minus + "분");
		
		/*
		int hourYesterDay = 10;
		int minuteYesterDay = 20;

		// 오늘의 시간과 분
		int hourToDay = 11;
		int minuteToDay = 50;

		int totalHour = (hourYesterDay + hourToDay) + ((minuteYesterDay + minuteToDay)/60);
		int totalMinute = (minuteYesterDay + minuteToDay)%60;

		int minusTime = (hourYesterDay * 60 + minuteYesterDay) - (hourToDay * 60 + minuteToDay);
		if(minusTime < 0) {
			minusTime = -minusTime;
		}

		System.out.println("어제 총 공부한 시간은 " + totalHour + " 시간 " + totalMinute + " 분 입니다.");
		System.out.println("어제와 오늘 공부한 시간의 차이는 " + minusTime + "분");
		 */
	
	}
}
