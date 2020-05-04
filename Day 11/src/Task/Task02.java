package Task;

import java.util.Random;

public class Task02 {

	public static void main(String[] args) {
//		5 X 5 빙고판 만들기
//		1 ~ 25까지 랜덤하게 작성되도록 5 X 5 빙고판을 출력하라

		// 입력
		Random r = new Random();
		int gameLevel = 4;
		int num = 1;
		int[][] bingo = new int[gameLevel][gameLevel];
		int[][] save = new int[gameLevel][gameLevel];

		// [0][0] ~ [5][5]의 인덱스에 1 ~ 25까지의 숫자 넣기
		for (int i = 0; i < bingo.length; i++) {
			for (int k = 0; k < bingo[i].length; k++) {
				bingo[i][k] = num++;
				save[i][k] = bingo[i][k];
			}
		}

		// 배열 랜덤 배치 (반으로 나눠 뒤집기)
		for (int i = 0; i < bingo.length / 2; i++) {
			for (int k = 0; k < bingo[i].length; k++) {
				int a = r.nextInt(bingo.length - bingo.length / 2) + bingo.length / 2;
				int b = r.nextInt(bingo[i].length);

				bingo[i][k] = bingo[a][b];
				bingo[a][b] = save[i][k];
			}
		}

		// 출력
		for (int i = 0; i < bingo.length; i++) {
			System.out.print("\t[" + (char) (i + 97) + "]");
		}
		System.out.println();

		for (int i = 0; i < bingo.length; i++) {
			System.out.print("[" + (char) (i + 65) + "]\t");
			for (int k = 0; k < bingo[i].length; k++) {
				System.out.print(bingo[i][k] + "\t");
			}
			System.out.println("\n");
		}
	}
}
