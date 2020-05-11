package OOP.Inherit_5;

// 추상적 클래스
//	공통 부분만 정의하고 생성은 안하는게 좋다. (앰맴몸홈)

public class Phone {
	
//	상위 클래스를 만들 때는 접근 제한을 고민해봐야 한다.
//	-	private > 자신을 제외한 모두를 차단하고 싶을 때
//	-	protected > 우리, 상속 받는 클래스들에게 허용
	protected String num;
	
	public void info() {
		System.out.println("이 휴대폰 제조사는 입니다.");
	}

}
