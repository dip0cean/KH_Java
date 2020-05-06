package OOP.v0.Task01.LE;

public class GameRoom {

	public static void main(String[] args) {

//		기기 생성		
		Arcade a1 = new Arcade();
		Arcade a2 = new Arcade();
		Arcade a3 = new Arcade();

//		기본 정보 설정
		a1.setting("스노우맨", 300);
		a2.setting("보글보글", 500);
		a3.setting("철권", 1000);
		
//		기본 정보 출력
		a1.output();
		a2.output();
		a3.output();

//		게임을 이용하는 것과 동일한 처리를 수행하는 코드		
		a1.play();
		a2.play();
		a3.play();

//		이후 정보 출력
		a1.output();
		a2.output();
		a3.output();
		
//		메소드 오버로딩		
		a1.setting("스노우맨", 300);
		a2.setting("보글보글", 500);
		a3.setting("철권", 1000);
		
		a1.output();
		a2.output();
		a3.output();
	}

}
