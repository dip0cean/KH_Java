package homepage.servlet.post;

import homepage.beans.dao.PostDAO;
import homepage.beans.dto.PostDTO;

public class testServlet {
	
	public static void main(String[] args) throws Exception {
		
		PostDAO pdao = new PostDAO();
		
		PostDTO pdto = new PostDTO();
		
		pdto.setPost_id("master");
		pdto.setPost_sub("일반");
		pdto.setPost_title("제목테스트");
		pdto.setPost_content("내용 테스트");
		
		pdao.creatPost(pdto);
		
		System.out.println("성공");
	}
	
}
