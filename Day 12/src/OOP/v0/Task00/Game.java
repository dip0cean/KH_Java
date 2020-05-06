package OOP.v0.Task00;

public class Game {

	public static void main(String[] args) {
		
//		객체 생성		
		Player bbororo = new Player();
		Player mario = new Player();
		Player ruigi = new Player();
		
//		객체 설정		
		bbororo.setting("뽀로로", "전사", 50, 50000);
		mario.setting("마리오", "법사", 45, 65000);
		ruigi.setting("루이지", "전사", 53, 70000);
		
//		객체 출력		
		System.out.println("닉네임 | " + "직업 | " + "레벨  | " + " 소지금");
		System.out.println("-----------------------------------");
		bbororo.output();
		mario.output();
		ruigi.output();

	}

}
