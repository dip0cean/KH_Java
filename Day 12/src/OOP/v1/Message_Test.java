package OOP.v1;

public class Message_Test {

	public static void main(String[] args) {
//		Message 를 생성
		
//		객체 생성 코드
//		1) Random 클래스나 Scanner 클래스와 비슷한 구성
//		2) 배열 생성과 다르다.
		Message a = new Message();
	
//		생성된 클래스의 변수들을 불러오는 과정		
		a.sender = "하은";
		a.content = "안뇽?쮜직";
		a.when = "12시 30분";
		a.remain = 1;
		
//		클래스 출력		
		System.out.println(a.sender);
		System.out.println(a.content);
		System.out.println(a.when);
		System.out.println(a.remain);

	}

}
