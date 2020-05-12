package OOP.Inherit.Constructor_0;

//	상위 클래스(추상적인..)
public class Phone {
	protected String num;
	protected String telecom;

//	생성자를 통해서 Phone 의 필수 항목들을 초기화
	public Phone(String num, String telecom) {
		this.num = num;
		this.telecom = telecom;
	}
}
