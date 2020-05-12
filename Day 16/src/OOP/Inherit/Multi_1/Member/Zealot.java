package OOP.Inherit.Multi_1.Member;

import OOP.Inherit.Multi_1.Char.Protoss;
import OOP.Inherit.Multi_1.Type.GroundUnit;

public class Zealot extends Protoss implements GroundUnit{

	public Zealot() {
		super("질럿");
	}

	@Override
	public void ground() {
		System.out.println("속성 : 지상 유닛");
		
	}

}
