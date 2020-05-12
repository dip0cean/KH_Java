package OOP.Inherit.Multi_1.Unit;

import OOP.Inherit.Multi_1.Type.GroundUnit;
import OOP.Inherit.Multi_1.kind.Protoss;

public class Zealot extends Protoss implements GroundUnit {

	@Override
	public void walk() {
		System.out.println("속성 : 지상 유닛");
		
	}


}
