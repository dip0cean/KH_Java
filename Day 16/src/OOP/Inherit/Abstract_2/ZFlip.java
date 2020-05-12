package OOP.Inherit.Abstract_2;

public class ZFlip extends Phone {

	@Override
	public void call() {
		System.out.println("ZFlip 의 전화 기능을 실행합니다.");

	}

	@Override
	public void sms() {
		System.out.println("ZFlip 의 문자 기능을 실행합니다.");

	}

	@Override
	public void camera() {
		System.out.println("ZFlip 의 카메라 기능을 실행합니다.");

	}

}
