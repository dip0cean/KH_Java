package Array_2;

public class Test03 {

	public static void main(String[] args) {
//		다음 성적 정보를 저장하고 문제를 푸세요.
//		각 반 학생들의 성적
		int[][] score = { 
				{ 50, 75, 90, 40, 80 }, // score[0][x]
				{ 66, 70, 55, 85, 70 }, // score[1][y]
				{ 60, 50, 80, 90, 95 } // score[2][z]
		};

//		1) 	1반 학생들의 성적을 있는 그대로 화면에 출력
		System.out.println("1) 0반 전체 학생 성적 > ");
		for (int i = 0; i < score[1].length; i++) {
			System.out.print("[0][" + i + "] = " + score[1][i] +"점 \t");
		}
		System.out.println("\n");

//		2)	각 반 학생들의 성적 평균을 구하여 화면에 출력
		System.out.println("2) 각 반 학생들의 평균 성적 > ");
		double[] sum = new double[score.length];
		double[] avg = new double[score.length];
		for (int i = 0; i < score.length; i++) {
			for (int k = 0; k < score[i].length; k++) {
				sum[i] += score[i][k];
			}
			avg[i] = sum[i] / score[i].length;

			System.out.println(i + "반 학생들의 병균 점수 > " + avg[i] + " 점");
		}
		System.out.println();

//		3)	72점인 학생의 전체 석차를 예상하여 출력
		System.out.println("3) 석차 조회 > ");
		int myScore = 72;
		int count = 1;

		for (int i = 0; i < score.length; i++) {
			for (int k = 0; k < score[i].length; k++) {
				if (score[i][k] > myScore) {
					count++;
				}
			}
		}
		System.out.println("나의 등수는 " + count + "등이다.");
	}

}
