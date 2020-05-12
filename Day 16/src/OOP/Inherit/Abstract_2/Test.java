package OOP.Inherit.Abstract_2;

import java.util.Random;

public class Test {
	public static final int ZFLIP = 0;
	public static final int V60 = 1;
	public static final int IPHONE11 = 2;

	public static final int CALL = 0;
	public static final int SMS = 1;
	public static final int CAMERA = 2;

	public static void main(String[] args) {
//		랜덤 생성자		
		Random r = new Random();

//		Phone 추상 클래스 선언 전		
		Phone a;
		

//		배열 인덱스에 추첨 번호 넣기	
		int[] data = new int[2];

		for (int i = 0; i < data.length; i++) {
			data[i] = r.nextInt(3);
		}

//		랜덤 스마트폰		
		switch (data[0]) {
		case ZFLIP:
			a = new ZFlip();
			break;
		case V60:
			a = new V60();
			break;
		default:
			a = new iPhone11();
			break;
		}

//	 랜덤 기능		
		switch (data[1]) {
		case CALL:
			a.call();
			break;
		case SMS:
			a.sms();
			break;
		default:
			a.camera();
			break;
		}

	}

}
