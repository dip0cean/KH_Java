package homepage.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import homepage.beans.dao.MemberDAO;
import homepage.beans.dto.MemberDTO;

public class TestLoginFilter implements Filter {
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		
		try {

			// 다운 캐스팅

//		목표 > 서버를 실행하기만 하면 로그인이 되어 있도록 구현하는 것
//		-	개발용으로 서비스 배포 시 반드시 제거해야 한다.

//		계획 > 
//		1. 현재 요청을 보낸 사용자의 로그인 여부를 조사
			MemberDTO mdto = (MemberDTO) req.getSession().getAttribute("userinfo");
			MemberDAO mdao = new MemberDAO();

//		2. 1번에서 로그인이 되어 있다면 통과 / 안되어 있다면 로그인 처리를 수행
			if (mdto == null) {
//		3. 2번에서 불러운 정보를 세션에 저장 후 통과		
//		-	DB 에 아이디를 미리 만들어 두었다면 그 아이디를 불러와서 처리
//		-	DB 에 아이디를 만들어 두지 않았다면 신규 가입 처리 후 수행
				MemberDTO user;
				user = mdao.get("sample");

				if (user == null) {
					MemberDTO sample = new MemberDTO();
					sample.setMember_id("sample");
					sample.setMember_pw("12345678");
					sample.setMember_nick("샘플계정");
					sample.setMember_post("000000");
					sample.setMember_base_addr("테스트 기본주소");
					sample.setMember_extra_addr("테스트 상세주소");
					sample.setMember_birth("2000-01-01");
					sample.setMember_phone("01098986565");
					sample.setMember_intro("테스트 샘플 계정");
					
					mdao.join(sample);
					
					user = mdao.get("sample");
				}

				req.getSession().setAttribute("userinfo", user);

			}

				chain.doFilter(request, response);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			resp.sendError(500);
			
		}

	}
}
