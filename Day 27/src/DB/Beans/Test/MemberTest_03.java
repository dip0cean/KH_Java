package DB.Beans.Test;

import java.util.Scanner;

import DB.Beans.DAO.MemberDAO;
import DB.Beans.DTO.MemberDTO;

public class MemberTest_03 {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		MemberDAO mdao = new MemberDAO();
		MemberDTO mdto = new MemberDTO();

		System.out.print("닉네임 > ");
		mdto.setMember_nick(sc.nextLine());
		System.out.print("전화번호 > ");
		mdto.setMember_phone(sc.nextLine());
		sc.close();

		String result = mdao.findId(mdto);
		
		if(result == null) {
			System.out.println("아이디를 찾을 수 없습니다.");
		} else {
			System.out.println("아이디 > " + result);
		}

	}

}
