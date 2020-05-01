package Array_2;

public class Test02 {
	public static void main(String[] args) {
//		Test01 을 2차원 배열로 풀이
//		int[] a = new int[] { 50, 60, 70 };
//		int[] b = new int[] { 75, 65, 70 };

//		int[][] c = new int[줄][칸];
//		int[][] c = new int[2차원 크기][1차원 크기];
//		c --------> 	c[0] --------> [0][0][0]
//						c[1] --------> [0][0][0]

		int[][] c = new int[2][3];
		int[][] d = new int[][] { { 50, 60, 70 }, { 75, 65, 70 } };
		
//		출력
		for(int i = 0; i < d[0].length; i++) {
			System.out.println(d[0][i]);
		}
		System.out.println();
		for(int i = 0; i < d[1].length; i++) {
			System.out.println(d[1][i]);
		}
		System.out.println();
		
//		2차원 배열 출력 공식 (거의)
		for(int i = 0; i < c.length; i++) {
			for(int k = 0; k < d[i].length; k++) {
				System.out.print(d[i][k] + "\t");
			}
			System.out.println();
		}
	}

}
