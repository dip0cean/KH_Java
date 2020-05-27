package DB.Insert;

import java.util.Scanner;

import DB.Beans.StudentDAO;

public class Test02 {

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);

		StudentDAO sdao = new StudentDAO();
		System.out.println("학생 이름과 점수를 입력해주세요.");
		sdao.regist(sc.nextLine(), sc.nextInt());

		sc.close();

	}
}
