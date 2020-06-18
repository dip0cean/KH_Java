package homepage.servlet;

import homepage.beans.dao.ReplyDAO;


public class testServlet {

	public static void main(String[] args) throws Exception {

		ReplyDAO rdao = new ReplyDAO();
		
		long reply_no = rdao.getReply_no();
		
		System.out.println(reply_no);
	}

}
