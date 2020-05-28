package DB.Update;

import java.util.Scanner;

public class StudentTest_02 {

	public static void main(String[] args) throws Exception {
		// StudentDAO 를 이용하여 학생 및 점수 수정
		Scanner sc = new Scanner(System.in);
		StudentDAO sdao = new StudentDAO();
		StudentDTO sdto = new StudentDTO();

		System.out.print("번호를 입력해주세요 > ");
		sdto.setStudent_no(sc.nextInt());
		System.out.print("이름을 입력해주세요 > ");
		sdto.setStudent_name(sc.next()); // nextLine() 메소드를 사용하면 다음 단계로 진행하기에 사용 X
		System.out.print("점수를 입력해주세요 > ");
		sdto.setStudent_score(sc.nextInt());
		sc.close();

		boolean result = sdao.edit(sdto);

		if (result) {
			System.out.println("수정이 완료되었습니다.");
		} else {
			System.out.println("수정할 수 없습니다.");
		}

	}

}
