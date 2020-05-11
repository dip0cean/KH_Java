package OOP.Inherit_Task_Phone;

import OOP.Inherit_Task_Galaxy.GalaxyNote10;
import OOP.Inherit_Task_Galaxy.GalaxyS10;
import OOP.Inherit_Task_iPhone.iPhone10;
import OOP.Inherit_Task_iPhone.iPhone11;

public class Test {
	public static void main(String[] args) {
//		Galaxy S10		
		GalaxyS10 a = new GalaxyS10();

		System.out.println("<Galaxy S10>");
		a.num = "010-9467-6216";
		a.call();
		a.sms();
		a.bixby();
		System.out.println();

//		Galaxy Note 10
		GalaxyNote10 b = new GalaxyNote10();
		System.out.println("<Galaxy Note 10>");
		b.num = "010-1234-5678";
		b.call();
		b.sms();
		b.memo();
		System.out.println();

//		iPhone 10
		iPhone10 c = new iPhone10();
		System.out.println("<iPhone 10>");
		c.num = "010-9876-5432";
		c.call();
		c.airdrop();
		c.itunes();
		System.out.println();

//		iPhone 11
		iPhone11 d = new iPhone11();
		System.out.println("<iPhone 11>");
		d.num = "010-1122-3344";
		d.call();
		d.airdrop();
		d.siri();

	}

}
