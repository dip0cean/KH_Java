package homepage.servlet.admin;

import java.util.List;

import homepage.beans.dao.MemberDAO;
import homepage.beans.dto.MemberDTO;

public class sdfsdfsdf {

	public static void main(String[] args) throws Exception {
		MemberDAO mdao = new MemberDAO();
		
		String type = "ACCESS_AUTH";
		
		String keyword = "운영";	
		
		List<MemberDTO> list = mdao.search(type, keyword);
		
		for(MemberDTO mdto : list) {
			
			System.out.println(mdto.getMember_id());
			
		}
		

	}

}
