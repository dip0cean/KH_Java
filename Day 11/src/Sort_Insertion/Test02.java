package Sort_Insertion;

public class Test02 {

	public static void main(String[] args) {
		int[] data = new int[] { 11, 2, 1, 8, 3, 7, 10, 4, 6, 5, 9 };
		int save, index;
		for (int i = 0; i < data.length; i++) {
			for (int k = i; k >= 0; k--) {
				index = k+1;
				save = data[k];
				if (index < data.length && data[k] > data[index]) {
					data[k] = data[index];
					data[index] = save;

				}

			}

		}
		for (int i = 0; i < data.length; i++) {
			System.out.println("data[" + i + "] = " + data[i]);
		}
	}

}
