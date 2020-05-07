package OOP.Constructor_2;

public class Result {

	public static void main(String[] args) {
//		주사위를 2번씩 10세트 던진 결과를 저장 및 출력
//		[1] 2차원 배열 - 10줄 2칸
//		[2] 객체 배열 - 세트 객체 10개

//		객체 배열은 객체를 생성하는게 아닌 객체가 들어갈 "공간" 을 만들었다는 의미		
		Dice[] data = new Dice[10];

//		반복문을 통해 만들어진 각각의 인덱스에 객체를 생성
//		출력을 원하면 출력 메소드를 불러온다.		
		for (int i = 0; i < data.length; i++) {
			data[i] = new Dice();
			data[i].output();
		}

	}

}
