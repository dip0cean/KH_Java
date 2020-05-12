package OOP.Inherit.Multi_1.Char;

import OOP.Inherit.Multi_1.Unit.Unit;

public class Terran extends Unit {

	public Terran(String name) {
		super(name, "테란");
		System.out.println("이름 : " + super.name + "\n종족 : " + super.character);

	}

	public Terran() {
		super("null", "테란");
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
