package OOP.Inherit.Multi_1.Unit;

import OOP.Inherit.Multi_1.Type.FlyingUnit;
import OOP.Inherit.Multi_1.kind.Terran;

public class Wraith extends Terran implements FlyingUnit {

	@Override
	public void fly() {
		System.out.println("속성 : 비행 유닛");
		
	}

}
