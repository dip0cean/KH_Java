package OOP.Inherit.Multi_1.Member;

import OOP.Inherit.Multi_1.Char.Zerge;
import OOP.Inherit.Multi_1.Type.FlyUnit;
import OOP.Inherit.Multi_1.Type.WorkUnit;

public class Overload extends Zerge implements FlyUnit, WorkUnit {

	public Overload() {
		super("오버로드");

	}

	@Override
	public void fly() {
		System.out.println("속성 : 비행 유닛");

	}

	@Override
	public void work() {
		System.out.println("속성 : 일꾼 유닛");

	}

}
