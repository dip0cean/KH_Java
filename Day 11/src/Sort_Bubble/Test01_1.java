package Sort_Bubble;

public class Test01_1 {
	public static void main(String[] args) {
		int[] data = new int[] { 5, 3, 2, 1, 4 };
		int number = 0;

		if (data[0] > data[1]) {
			number = data[0];
			data[0] = data[1];
			data[1] = number;
		}
		System.out.println(data[0]);
		System.out.println(data[1]);
		System.out.println();

		if (data[1] > data[2]) {
			number = 0;
			number = data[1];
			data[1] = data[2];
			data[2] = number;
		}
		System.out.println(data[0]);
		System.out.println(data[1]);
		System.out.println(data[2]);
		System.out.println();

		if (data[2] > data[3]) {
			number = 0;
			number = data[2];
			data[2] = data[3];
			data[3] = number;
		}
		System.out.println(data[0]);
		System.out.println(data[1]);
		System.out.println(data[2]);
		System.out.println(data[3]);
		System.out.println();

		if (data[3] > data[4]) {
			number = 0;
			number = data[3];
			data[3] = data[4];
			data[4] = number;
		}
		System.out.println(data[0]);
		System.out.println(data[1]);
		System.out.println(data[2]);
		System.out.println(data[3]);
		System.out.println(data[4]);
		System.out.println();
	}

}
