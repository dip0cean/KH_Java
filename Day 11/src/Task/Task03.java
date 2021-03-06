package Task;

import java.util.Random;

public class Task03 {
	public static void main(String[] args) {
//		9 X 9 크기의 지뢰 게임을 만드세요.
//		지뢰의 개수는 총 20개, 자리는 랜덤

//		입력
		Random r = new Random();
		int[][] mineGame = new int[9][9];
		int count = 0;
		int mine;

//		연산		
		for (int i = 0; i < mineGame.length; i++) {
			for (int k = 0; k < mineGame[i].length; k++) {
				mine = r.nextInt(100);
				if (mine < 25) {
					count++;
					if (count <= 20) {
						mineGame[i][k] = 9;
					}
				}
			}
		}

// 		출력
		for (int i = 0; i < mineGame.length; i++) {
			System.out.print("[" + (char) (i + 65) + "]\t");
			for (int k = 0; k < mineGame[i].length; k++) {
				System.out.print(mineGame[i][k] + "  |  ");
			}
			System.out.println("\n------------------------------------------------------------");
		}
	}

}
