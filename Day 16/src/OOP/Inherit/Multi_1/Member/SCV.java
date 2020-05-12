package OOP.Inherit.Multi_1.Member;

import OOP.Inherit.Multi_1.Char.Terran;
import OOP.Inherit.Multi_1.Type.GroundUnit;
import OOP.Inherit.Multi_1.Type.WorkUnit;

public class SCV extends Terran implements GroundUnit, WorkUnit {

	public SCV() {
		super("SCV");

	}

	@Override
	public void work() {
		System.out.println("속성 : 일꾼 유닛");

	}

	@Override
	public void ground() {
		System.out.println("속성 : 지상 유닛");

	}

}
