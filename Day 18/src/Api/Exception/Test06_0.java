package Api.Exception;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class Test06_0 {
	// @SuppressWarnings({ "resource" })
	public static void main(String[] args) {
//		사용자에게 자장면과 짬뽕 그릇 수를 입력받아 합계 금액을 계산하는 프로그램을 구현
//		-	최소 입력 가능 수량은 1개
//		-	잘못된 입력을 할 경우에는 예외 처리를 통하여 메세지를 출력

		Scanner sc = new Scanner(System.in);
		try {
			int chinaNoddle = 4000;
			int jjambbong = 4500;

			System.out.println("자장면 주문 개수 : ");
			int cWant = sc.nextInt();

			System.out.println("짬뽕 주문 개수 : ");
			int jWant = sc.nextInt();
			sc.close();
			
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
