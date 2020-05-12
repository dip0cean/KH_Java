package OOP.Inherit.Multi_1.Unit;

import OOP.Inherit.Multi_1.Type.GroundUnit;
import OOP.Inherit.Multi_1.Type.Worker;
import OOP.Inherit.Multi_1.kind.Terran;

public class SCV extends Terran implements GroundUnit, Worker {

	@Override
	public void work() {
		System.out.println("속성 : 일꾼 유닛");
		
	}

	@Override
	public void walk() {
		System.out.println("속성 : 지상 유닛");
		
	}


}
