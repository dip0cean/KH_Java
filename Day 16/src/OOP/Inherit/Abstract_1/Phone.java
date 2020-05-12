package OOP.Inherit.Abstract_1;

//	추상 클래스 ( Abstract Class)
//	-	상속 관계에서 상위 역할을 수행하는 클래스
//	-	"추상 메소드" 를 가질 수 있고 객체 생성이 불가능
//	-	추상 클래스는 상위 클래스에서 생성
//	-	하위 클래스들의 기준이 되는 개념
public abstract class Phone {
	protected String num;

//	-	추상 메소드 : 형태만 있고 내용이 없는 메소드
//	-	추상적인 메소드를 하위 클래스에서 구체화 할 수 있도록
	public abstract void call();

	public abstract void sms();

	public abstract void internet();
}
