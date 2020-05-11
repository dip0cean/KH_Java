package OOP.Inherit_4_2;

import OOP.Inherit_4_1.Chrome;
import OOP.Inherit_4_1.FireFox;

public class Test {
	public static void main(String[] args) {
		Chrome a = new Chrome();

		a.setUrl("http://www.google.com");
		a.setVer("v0.1");
		a.move();
		a.back();
		a.store();

		FireFox b = new FireFox();

		b.setUrl("http://www.mozila.com");
		b.setVer("v0.01");
		a.move();
		a.back();

	}
}
