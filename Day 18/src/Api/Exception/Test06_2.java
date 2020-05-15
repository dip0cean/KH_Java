package Api.Exception;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class Test06_2 {
	public static void main(String[] args) {
//		try ~ with 구문 : 자동 close 를 수행

		try (Scanner sc = new Scanner(System.in);) {
			int chinaNoddle = 4000;
			int jjambbong = 4500;

			System.out.println("자장면 주문 개수 : ");
			int cWant = sc.nextInt();

			System.out.println("짬뽕 주문 개수 : ");
			int jWant = sc.nextInt();

			if (jWant <= 0 && cWant <= 0) {

				throw new Exception("1개 이상 입력해주세요.");
			}

			int result1 = chinaNoddle * cWant;
			int result2 = jjambbong * jWant;
			int result3 = result1 + result2;

			System.out.println("자장면 결제 금액 : " + result1 + "원");
			System.out.println("짬뽕 결제 금액 : " + result2 + "원");
			System.out.println("총 결제 금액 : " + result3 + "원");

		} catch (Exception e) {
			if (e.getMessage() == null) {
				System.err.println("주문 개수를 다시 입력해주세요");
				JOptionPane.showMessageDialog(null, "잘가");
			} else {
				System.err.println(e.getMessage());
			}
		}
	}
}
