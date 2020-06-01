package Task;


public class Task06_1 {

//		데이터를 배열에 저장하고 주어진 문제에 맞게 위치를 조작하여 출력
//		Q1 > 데이터의 순서를 거꾸로 바꾸어 출력(데이터 개수가 달라져도 처리)

	public static void main(String[] args) {

		String[] name = new String[] { "Java", "JavaScript", "Python", "Ruby", "C#", "TypeScript", "React", "Kotlin" };

		int length = name.length - 1; // String 인덱스를 역순으로 돌리기 위해

		for (int i = 0; i < length / 2; i++) {
			String a = name[i];
			name[i] = name[length - i];
			name[length - i] = a;
		}
		for (int i = 0; i < name.length; i++) {
			System.out.println("name[" + i + "] = " + name[i]);
		}
	}
}
