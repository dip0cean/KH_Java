package Sort_Bubble;

public class Test01_3 {
	public static void main(String[] args) {

		int[] data = new int[] { 6, 5, 3, 1, 8, 7, 2, 4, 10, 11, 18, 13, 12, 15, 16, 17, 14, 9 };
		for (int k = data.length - 1; k > 0; k--) {
			for (int i = 0; i < k; i++) {
				if (data[i] > data[i + 1]) {
					int number = data[i];
					data[i] = data[i + 1];
					data[i + 1] = number;
				}
			}
		}
		for (int i = 0; i < data.length; i++) {
			System.out.println("data[" + i + "] = " + data[i]);
		}
	}
}
