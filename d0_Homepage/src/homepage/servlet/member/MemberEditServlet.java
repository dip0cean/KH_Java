package homepage.servlet.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import homepage.beans.dao.MemberDAO;
import homepage.beans.dto.MemberDTO;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/member/edit.do")
public class MemberEditServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			req.setCharacterEncoding("UTF-8");
			
			// 정보 수정
			MemberDTO userinfo = (MemberDTO) req.getSession().getAttribute("userinfo");
			MemberDAO mdao = new MemberDAO();
			MemberDTO mdto = new MemberDTO();
			
			mdto.setMember_id(userinfo.getMember_id());
			mdto.setMember_pw(userinfo.getMember_pw());
			mdto.setMember_nick(req.getParameter("member_nick"));
			mdto.setMember_post(req.getParameter("member_post"));
			mdto.setMember_base_addr(req.getParameter("member_base_addr"));
			mdto.setMember_extra_addr(req.getParameter("member_extra_addr"));
			mdto.setMember_birth(userinfo.getMember_birthday());
			mdto.setMember_phone(req.getParameter("member_phone"));
			mdto.setMember_intro(req.getParameter("member_intro"));
			mdto.setAccess_auth(userinfo.getAccess_auth());
			mdto.setAccess_join(userinfo.getAccess_join());
			mdto.setAccess_login(userinfo.getAccess_login());
			
			mdao.edit(mdto);
			
			// 단일 조회로 최신 정보 갱신
			String member_id = userinfo.getMember_id();
			
			mdto = mdao.get(member_id);
			req.getSession().setAttribute("userinfo", mdto);
			
			resp.sendRedirect("edit_userinfo.jsp?succ");
		
		} catch (Exception e) {
				
			e.printStackTrace();
			resp.sendError(500);
		}
	}
}
