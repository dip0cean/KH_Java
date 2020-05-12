package OOP.Inherit.Multi_0;

// 강사 인터페이스
//	-	다중 상속 전용 클래스 > 클래스의 변형
//	-	클래스에서 다중 상속 시 문제가 되는 요소들이 모두 사라졌음
//	-	인터페이스에서는 변수 생성 불가 ( 상수만 가능 )
//	-	생성자 생성 불가 > 객체를 만들면 안되기 때문에.
//	-	메소드 생성 불가 > (단, 추상 메소드 및 default / static 메소드는 생성 가능)
public interface Teacher {
	int a = 10;
	String b = "자바";
	
	void teach();
}
