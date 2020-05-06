package OOP.v0.Task01.D0;

import java.util.Scanner;

public class GameRoom {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Arcade snowman = new Arcade();
		Arcade boggle = new Arcade();
		Arcade tekken = new Arcade();
		
		System.out.println("누적 횟수를 입력하세요. > ");
		snowman.setting("스노우맨", 300, sc.nextInt());
		boggle.setting("보글보글", 500, sc.nextInt());
		tekken.setting("철권\t", 1000, sc.nextInt());
		sc.close();
		
		snowman.output();
		boggle.output();
		tekken.output();
		
	}

}
