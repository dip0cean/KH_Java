package OOP.Inherit.Multi_1.Char;

import OOP.Inherit.Multi_1.Unit.Unit;

public class Protoss extends Unit {

	public Protoss(String name) {
		super(name, "프로토스");
		System.out.println("이름 : " + super.name + "\n종족 : " + super.character);

	}

	public Protoss() {
		super("null", "프로토스");
		System.out.println("이름 : " + super.name + "\n종족 : " + super.character);

	}

	@Override
	public void attack() {
		super.command = "공격을 명령합니다.";
	}

	@Override
	public void move() {
		super.command = "이동을 명령합니다.";

	}

}
