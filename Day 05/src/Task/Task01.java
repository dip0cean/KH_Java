package Task;

import java.lang.*;
import java.util.*;

public class Task01 {

	public static void main(String[] args) {
//		휘발유 1L 당 가격을 입력받아 예상 여행 경비를 계산하시오.
//		내 차는 1L에 10.5km를 달릴수 있다.	
//		서울 > 부산 > 목포 > 서울
//		서울 > 부산 : 450km
//		부산 > 목포 : 200km
//		목포 > 서울 : 400km

//		Scanner 도구 선언
		Scanner sc = new Scanner(System.in);

//		연비
		double myCar = 10.5;

//		휘발유 가격 및 이동 거리 입력		
		System.out.println("휘발유 가격을 입력하세요. > ");
		int oil = sc.nextInt(); // 휘발유 리터당 가격

		int distance = 1050; // 총 이동거리

//		계산
		double km = distance / myCar; // 이용해야 할 휘발유의 양
		double price = km * oil; // 총 경비

//		출력		
		System.out.println("총 이동거리 : " + (int) km + "km");
		System.out.println("총 결제 금액 : " + (int) price + "원");

		sc.close();
	}

}
