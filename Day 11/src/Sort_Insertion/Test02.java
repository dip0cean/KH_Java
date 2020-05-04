package Sort_Insertion;

public class Test02 {

	public static void main(String[] args) {
		int[] data = new int[] { 11, 2, 1, 8, 3, 7, 10, 4, 6, 5, 9 };
		int save;
		for (int i = 0; i < data.length; i++) {
			for (int k = i; k >= 0; k--) {
				save = data[k];
				if (k + 1 < data.length && data[k] > data[k + 1]) {
					data[k] = data[k + 1];
					data[k + 1] = save;

				}

			}

		}
		for (int i = 0; i < data.length; i++) {
			System.out.println("data[" + i + "] = " + data[i]);
		}
	}

}
