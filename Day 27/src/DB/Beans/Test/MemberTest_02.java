package DB.Beans.Test;

import java.util.Scanner;

import DB.Beans.DAO.MemberDAO;
import DB.Beans.DTO.MemberDTO;

public class MemberTest_02 {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		MemberDTO mdto = new MemberDTO();
		MemberDAO mdao = new MemberDAO();

		System.out.print("아이디 > ");
		mdto.setMember_id(sc.nextLine());
		System.out.print("패스워드 > ");
		mdto.setMember_pw(sc.nextLine());
		sc.close();
		boolean success = mdao.login(mdto);

		// 아이디와 패스워드 대조 후 카운트 확인
		if (success) {
			System.out.println("로그인 성공");
		} else {
			System.out.println("로그인 실패");
		}

		// 아이디와 패스워드 대조 후 전체 데이터 확인 > 데이터가 들어있는지 논리 확인
		success = mdao.login2(mdto);
		if (success) {
			System.out.println("로그인 성공");
		} else {
			System.out.println("로그인 실패");
		}
	}

}
