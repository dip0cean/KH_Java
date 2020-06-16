package homepage.servlet;

import java.util.List;

import homepage.beans.dao.MemberDAO;
import homepage.beans.dto.MemberDTO;

public class testServlet {

	public static void main(String[] args) throws Exception {

		MemberDAO mdao = new MemberDAO();
		List<MemberDTO> list = mdao.search();
		for (MemberDTO mdto : list) {
			System.out.println(mdto.getMember_id());
			System.out.println(mdto.getAccess_auth());
		}
	}

}
