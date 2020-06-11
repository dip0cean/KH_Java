package homepage.servler.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import homepage.beans.dto.MemberDTO;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/member/mypage.do")
public class MemberMypageServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MemberDTO user = (MemberDTO) req.getSession().getAttribute("userinfo");
		MemberDTO mdto = new MemberDTO();
		mdto.setMember_pw(req.getParameter("member_pw"));
		
		String a = user.getMember_pw();
		String b = mdto.getMember_pw();
		
		if(a.equals(b) ) {
			resp.sendRedirect("mypage_edit.jsp");
		} else {
			resp.sendRedirect("mypage.jsp?error");
		}
		

	}
}
