package DB.Beans.Test;

import java.util.Scanner;

import DB.Beans.DAO.MemberDAO;
import DB.Beans.DTO.MemberDTO;

public class MemberTest_01 {

	public static void main(String[] args) throws Exception {

		MemberDAO mdao = new MemberDAO();
		MemberDTO mdto = new MemberDTO();
		Scanner sc = new Scanner(System.in);

		System.out.print("아이디 > ");
		mdto.setMember_id(sc.nextLine());
		System.out.print("비밀번호 > ");
		mdto.setMember_pw(sc.nextLine());
		System.out.print("닉네임 > ");
		mdto.setMember_nick(sc.nextLine());
		System.out.print("우편번호 > ");
		mdto.setMember_post(sc.nextLine());
		System.out.print("기본주소 > ");
		mdto.setMember_base_addr(sc.nextLine());
		System.out.print("상세주소 > ");
		mdto.setMember_extra_addr(sc.nextLine());
		System.out.print("생년월일 > ");
		mdto.setMember_birth(sc.nextLine());
		System.out.print("전화번호 > ");
		mdto.setMember_phone(sc.nextLine());
		System.out.print("자기소개 > ");
		mdto.setMember_intro(sc.nextLine());
		sc.close();
		
		mdao.regist(mdto);

	}

}
