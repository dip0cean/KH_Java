package OOP.Inherit.Multi_1.Member;

import OOP.Inherit.Multi_1.Char.Terran;
import OOP.Inherit.Multi_1.Type.FlyUnit;

public class Wraith extends Terran implements FlyUnit{
	
	public Wraith() {
		super("레이스");
	}

	@Override
	public void fly() {
		System.out.println("속성 : 비행 유닛");
		
	}

}
