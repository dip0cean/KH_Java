package For;


public class Test04_2 {
	public static void main(String[] args) {
//		 다른 방법으로 접근
//		- 자리수가 달라져도 똑같이 처리하려면 어떻게 해야 할까?
//		- 어떤 숫자가 들어오던 간에 매 자리를 검사하도록 구현
		
//		count에 따라 박수 출력 / 숫자 출력
		
		for(int k = 1; k < 9; k++) {
			int n = k;
			int count = 0;
			for(int i = n; i > 0; i /= 10) {
				if(i % 10 == 3 || i % 10 == 6 || i % 10 == 9) {
					count++;
				}
			}
			if(count == 0) {
				System.out.println(n);
			} else {
				for(int m = 0; m < count; m++) {
					System.out.print("짝");
				}
				System.out.println();
			}
		}

	}

}
