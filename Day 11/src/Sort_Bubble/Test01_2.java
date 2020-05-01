package Sort_Bubble;

public class Test01_2 {
	public static void main(String[] args) {
		int[] data = new int[] { 5, 3, 4, 2, 1 };
		int number = 0;

		System.out.println("0번째 > ");
		for (int i = 0; i < data.length; i++) {
			System.out.print(data[i] + "\t");
		}
		System.out.println("\n");

		for (int i = 0; i < data.length - 1; i++) {
			if (data[i] > data[i + 1]) {
				number = 0;
				number = data[i];
				data[i] = data[i + 1];
				data[i + 1] = number;
			}
		}
		
		System.out.println("1번째 > ");
		for (int i = 0; i < data.length; i++) {
			System.out.print(data[i] + "\t");
		}
		System.out.println("\n");

		for (int i = 0; i < data.length - 2; i++) {
			if (data[i] > data[i + 1]) {
				number = 0;
				number = data[i];
				data[i] = data[i + 1];
				data[i + 1] = number;
			}
		}
		
		System.out.println("2번째 > ");
		for (int i = 0; i < data.length; i++) {
			System.out.print(data[i] + "\t");
		}
		System.out.println("\n");

		for (int i = 0; i < data.length - 3; i++) {
			if (data[i] > data[i + 1]) {
				number = 0;
				number = data[i];
				data[i] = data[i + 1];
				data[i + 1] = number;
			}
		}
		
		System.out.println("3번째 > ");
		for (int i = 0; i < data.length; i++) {
			System.out.print(data[i] + "\t");
		}
		System.out.println("\n");

		for (int i = 0; i < data.length - 4; i++) {
			if (data[i] > data[i + 1]) {
				number = 0;
				number = data[i];
				data[i] = data[i + 1];
				data[i + 1] = number;
			}
		}
		
		System.out.println("4번째 > ");
		for (int i = 0; i < data.length; i++) {
			System.out.print(data[i] + "\t");
		}
		System.out.println("\n");

	}

}
