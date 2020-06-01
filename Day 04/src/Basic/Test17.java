package Basic;

public class Test17 {
	public static void main(String[] args) {
//		논리형 자료형 > boolean
		boolean a = true;
		
		System.out.println(a);
	
//		실제 사용 : 숫자를 이용해서 논리를 계산한다. (ex. 비교)
		int pizza = 30000;
		int money = 35000;
		
//		boolean buy = 내 돈이 피자값보다 많은가?
		boolean buy = money >= pizza;
		System.out.println(buy);
		
	}
}
