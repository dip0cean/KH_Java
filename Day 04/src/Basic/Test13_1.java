package Basic;


public class Test13_1 {

	public static void main(String[] args) {

//		준비 : 신장(cm) , 체중(kg)
		double cm = 180;
		double kg = 80;

//		계산 : 신장(m) , BMI 지수
		double m = cm / 100;

		double bmi = kg / (m * m); // == kg / m / m

//		결과
		System.out.println("BMI 지수 : " + bmi);

//		소수점 2자리까지만 표시하도록 값 수정
		bmi = (int) (bmi * 100) / 100.0; // 곱했을 때 소수점이 없으면 int 타입인 상태에서 연산이 되기 때문에 기존 값의 뒤 소수점 자리수는 날라간다.
		System.out.println("BMI 지수 : " + bmi);

	}

}
