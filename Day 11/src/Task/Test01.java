package Task;

import java.util.Random;

public class Test01 {
	public static void main(String[] args) {
		Random r = new Random();
		int[][] game = new int[9][9];

//	1. 지뢰 랜덤 배치
		for (int n = 0; n < 21; n++) {
			int i = r.nextInt(game.length);
			int j = r.nextInt(game.length);

			while (game[i][j] == 9) {
				i = r.nextInt(game.length);
				j = r.nextInt(game.length);
			}
			game[i][j] = 9;
		}

//	2. 주변 지뢰 개수 count		
		for (int n = 0; n < game.length; n++) {
			for (int m = 0; m < game.length; m++) {
				int count = 0;
				for (int i = n - 1; i <= n + 1; i++) {
					for (int j = m - 1; j <= m + 1; j++) {
						if (i < 0 || j < 0 || game.length == i || game.length == j) {
						} else if (game[n][m] != 9 && game[i][j] == 9) {
							count++;
						}
					}
				}
				game[n][m] += count;
			}
		}
//	출력
		for (int i = 0; i < game.length; i++) {
			for (int j = 0; j < game.length; j++) {
				System.out.print(game[i][j]);
				System.out.print("\t");
			}
			System.out.println();
		}
	}
}
