package OOP.Inherit.Multi_1.Unit;

import OOP.Inherit.Multi_1.Type.FlyingUnit;
import OOP.Inherit.Multi_1.Type.Worker;
import OOP.Inherit.Multi_1.kind.Zerg;

public class Overlord extends Zerg implements FlyingUnit, Worker {

	@Override
	public void work() {
		System.out.println("속성 : 일꾼 유닛");
		
	}

	@Override
	public void fly() {
		System.out.println("속성 : 비행 유닛");
		
	}


}
