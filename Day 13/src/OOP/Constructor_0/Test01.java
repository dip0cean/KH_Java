package OOP.Constructor_0;

public class Test01 {
	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in); > 클래스의 생성자 개념

		Student s1 = new Student("피카츄", 100);
		
//		클래스의 메소드를 호출하여 생성자 값 변경 가능		
		s1.setting("라이츄", 150);

		s1.output();
	}
}
