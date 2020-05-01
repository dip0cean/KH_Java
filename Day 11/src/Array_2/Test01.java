package Array_2;

public class Test01 {
	public static void main(String[] args) {
//		1차원 배열을 이용하여 2개 반의 학생 점수를 보관 및 출력
//			- 각 반에는 학생이 3명씩 있다고 가정
//			- 변수로 풀면 변수 6개가 필요함 (모든 반의 인원수의 합) - 차원 X
//		1차원 배열로 풀면 배열 2개가 필요함 (반 개수대로) - 1차원
//		2차원 배열로 풀면 배열 1개가 필요함
		int[][] a = {{70,80,90}, {80,70,50}};
		
//		출력
		for(int i = 0; i < a.length; i++) {
			for(int k = 0; k < 3; k++) {
				System.out.println("a[" + i + "][" + k + "] = " + a[i][k]);
			}
		}

	}

}
