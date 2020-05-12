package OOP.Inherit.Multi_1.Test;

import java.util.Random;

import OOP.Inherit.Multi_1.Member.Overload;
import OOP.Inherit.Multi_1.Member.SCV;
import OOP.Inherit.Multi_1.Member.Wraith;
import OOP.Inherit.Multi_1.Member.Zealot;
import OOP.Inherit.Multi_1.Type.FlyUnit;
import OOP.Inherit.Multi_1.Type.GroundUnit;
import OOP.Inherit.Multi_1.Unit.Unit;

public class Test {

	public static void main(String[] args) {
		Random r = new Random();

//		유닛 생성
		Unit a;

//		유닛 랜덤 뽑기
		int unit = r.nextInt(4);

		if (unit == 0) {
			a = new SCV();
		} else if (unit == 1) {
			a = new Wraith();
		} else if (unit == 2) {
			a = new Zealot();
		} else {
			a = new Overload();
		}

//		유닛 n마리 만들기 (객체 배열)	
		Unit[] a1 = new Unit[10];
		System.out.println("종족 클래스 >");
		for (int i = 0; i < a1.length; i++) {
			a1[i] = a;
			a1[i].move();
			System.out.println((i + 1) + ". System > " + a1[i].getCharacter() + " 종족의 " + a1[i].getName()
					+ " 이(가) 생성되어 " + a1[i].getCommand());
		}

		System.out.println("\n지상 유닛 클래스 > ");

//		지상 유닛 생성
		Unit b;
//		지상 유닛 랜덤 뽑기
		unit = r.nextInt(2);

		if (unit == 0) {
			b = new SCV();
			((GroundUnit) b).ground();
		} else {
			b = new Zealot();
			((GroundUnit) b).ground();
		}

//		지상 n유닛 마리 만들기 (객체 배열) 	
		Unit[] b1 = new Unit[10];
		for (int i = 0; i < b1.length; i++) {
			b1[i] = b;
			b1[i].attack();
			System.out.println((i + 1) + ". System > " + b1[i].getCharacter() + " 종족의 " + b1[i].getName()
					+ " 이(가) 생성되어 " + b1[i].getCommand());
		}
		System.out.println("\n비행 유닛 클래스 > ");

//		지상 유닛 생성
		Unit c;
//		지상 유닛 랜덤 뽑기
		unit = r.nextInt(2);

		if (unit == 0) {
			c = new Wraith();
			((FlyUnit) c).fly();
		} else {
			c = new Overload();
			((FlyUnit) c).fly();
		}

//		지상 n유닛 마리 만들기 (객체 배열) 	
		Unit[] c1 = new Unit[10];
		for (int i = 0; i < c1.length; i++) {
			c1[i] = b;
			c1[i].attack();
			System.out.println((i + 1) + ". System > " + c1[i].getCharacter() + " 종족의 " + c1[i].getName()
					+ " 이(가) 생성되어 " + c1[i].getCommand());
		}
	}

}
