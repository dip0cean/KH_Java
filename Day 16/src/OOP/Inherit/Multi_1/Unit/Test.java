package OOP.Inherit.Multi_1.Unit;

import java.util.Random;

import OOP.Inherit.Multi_1.Char.Unit;
import OOP.Inherit.Multi_1.Type.FlyingUnit;
import OOP.Inherit.Multi_1.Type.GroundUnit;
import OOP.Inherit.Multi_1.Type.Worker;

public class Test {

	public static void main(String[] args) {
		Random r = new Random();
		Unit a;
		GroundUnit b;
		FlyingUnit c;

		int[] unit = new int[3];

		for (int i = 0; i < unit.length; i++) {
			unit[i] = r.nextInt(3);
		}


	}

}
