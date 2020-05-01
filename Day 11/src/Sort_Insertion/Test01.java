package Sort_Insertion;

public class Test01 {

	public static void main(String[] args) {
//		삽입 정렬
//			- 백업
//			- 현재 위치의 좌측을 탐색
//			- 삽입 되어야 할 위치를 정한다.
//				-백업 데이터보다 큰 데이터는 우측으로 한칸 이동
//				- 작거나 같다면 이동할 필요 없이 바로 뒤에 데이터 삽입 

		int[] data = new int[] { 5, 3, 2, 4, 1 };
		int save = data[0];
		for(int i = 0; i < data.length; i++) {
			System.out.println("data[" + i + "] = "  + data[i]);
		}
		System.out.println();
		
		if (data[0] > data[1]) {
			data[0] = data[1];
			data[1] = save;
		}
		System.out.println("date[0] = " + data[0]);
		System.out.println("date[1] = " + data[1]);
		System.out.println("date[2] = " + data[2]);
		System.out.println("date[3] = " + data[3]);
		System.out.println("date[4] = " + data[4]);
		System.out.println();
//////////////////////////////////////////////////////////////////////////////
		save = data[1];
		if (data[1] > data[2]) {
			data[1] = data[2];
			data[2] = save;
		}
		System.out.println("date[0] = " + data[0]);
		System.out.println("date[1] = " + data[1]);
		System.out.println("date[2] = " + data[2]);
		System.out.println("date[3] = " + data[3]);
		System.out.println("date[4] = " + data[4]);
		System.out.println();

		save = data[0];
		if (data[0] > data[1]) {
			data[0] = data[1];
			data[1] = save;
		}
		System.out.println("date[0] = " + data[0]);
		System.out.println("date[1] = " + data[1]);
		System.out.println("date[2] = " + data[2]);
		System.out.println("date[3] = " + data[3]);
		System.out.println("date[4] = " + data[4]);
		System.out.println();
///////////////////////////////////////////////////////////////////////////////
		save = data[2];
		if (data[2] > data[3]) {
			data[2] = data[3];
			data[3] = save;
		}
		System.out.println("date[0] = " + data[0]);
		System.out.println("date[1] = " + data[1]);
		System.out.println("date[2] = " + data[2]);
		System.out.println("date[3] = " + data[3]);
		System.out.println("date[4] = " + data[4]);
		System.out.println();

		save = data[1];
		if (data[1] > data[2]) {
			data[1] = data[2];
			data[2] = save;
		}
		System.out.println("date[0] = " + data[0]);
		System.out.println("date[1] = " + data[1]);
		System.out.println("date[2] = " + data[2]);
		System.out.println("date[3] = " + data[3]);
		System.out.println("date[4] = " + data[4]);
		System.out.println();
		
		save = data[0];
		if (data[0] > data[1]) {
			data[0] = data[1];
			data[1] = save;
		}
		System.out.println("date[0] = " + data[0]);
		System.out.println("date[1] = " + data[1]);
		System.out.println("date[2] = " + data[2]);
		System.out.println("date[3] = " + data[3]);
		System.out.println("date[4] = " + data[4]);
		System.out.println();
///////////////////////////////////////////////////////////////////////////////
	}
}
