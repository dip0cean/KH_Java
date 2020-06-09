package homepage.servler.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import homepage.beans.dao.MemberDAO;
import homepage.beans.dto.MemberDTO;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/member/join.do")
public class MemberJoinServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			// 입력 > join.jsp 의 9개 데이터 > MemberDTO 수신
			MemberDAO mdao = new MemberDAO();
			MemberDTO mdto = new MemberDTO();

			// 처리 > MemberDAO
			mdto.setMember_id(req.getParameter("member_id"));
			mdto.setMember_pw(req.getParameter("member_pw"));
			mdto.setMember_nick(req.getParameter("member_nick"));
			mdto.setMember_post(req.getParameter("member_post"));
			mdto.setMember_base_addr(req.getParameter("member_base_addr"));
			mdto.setMember_extra_addr(req.getParameter("member_extra_addr"));
			mdto.setMember_birth(req.getParameter("member_birth"));
			mdto.setMember_phone(req.getParameter("member_phone"));
			mdto.setMember_intro(req.getParameter("member_intro"));

			mdao.join(mdto);
			
			// 출력
			resp.sendRedirect("join_result.jsp");
			
			
		} catch (Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}
	}
}
