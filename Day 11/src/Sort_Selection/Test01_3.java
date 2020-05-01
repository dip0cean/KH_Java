package Sort_Selection;

public class Test01_3 {

	public static void main(String[] args) {

		int[] data = new int[] { 3, 5, 2, 1, 4, 6, 7, 8 };

//		전체 반복을 0 ~ 3까지 하는 이유는 
//		4번째 자리는 이미 3번째 반복에서 교체되었기 때문에 확인할 필요 없음
		for (int k = 0; k < data.length - 1; k++) {

//			 인덱스 0번이 제일 작다. (최소값 위치)
			int number = k;

			for (int i = number + 1; i < data.length; i++) {
				if (data[number] > data[i]) {
					number = i;
				}
			}

//		data[number] 의 데이터를 앞으로 이동
			int tmp = data[k];
			data[k] = data[number];
			data[number] = tmp;
		}
		for (int i = 0; i < data.length; i++) {
			System.out.println("data[" + i + "] = " + data[i]);
		}
	}

}
