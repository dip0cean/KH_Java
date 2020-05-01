package Sort_Selection;

public class Test01_2 {

	public static void main(String[] args) {

		int[] data = new int[] { 3, 5, 2, 1, 4 };

		int number = 0;

//		최소값이 들어있는 위치를 찾는 코드
		
		for(int i = 1; i < data.length; i++) {
			if(data[number] > data[i]) {
				number = i;
			}
		}
		for(int i = 0; i < data.length; i++) {
			System.out.println(data[i]);
		}
	}

}
