<%@page import="homepage.beans.dao.MemberDAO"%>
<%@page import="homepage.beans.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%
	String rootPath = request.getContextPath();
	MemberDTO mdto = (MemberDTO)session.getAttribute("userinfo"); 
	MemberDAO mdao = new MemberDAO();
	
	if(mdto != null) {

		mdto = mdao.get(mdto.getMember_id());
		
	}
	
	boolean isLogin = mdto != null;
%>

	<div class="center">
		<ul class="navi">
		<%if(isLogin) {%>
			<li><a href="<%=rootPath %>/member/logout.do"> Logout </a></li>
			<li><a href="<%=rootPath %>/member/mypage.jsp"> My page </a></li>
				
				<!-- 관리자 계정일 경우 -->
			<%if(mdto.getAccess_auth().equals("운영자")) { %>
				
			<li><a href="<%=rootPath %>/admin/home.jsp"> Setting </a></li>
				
				<%} %>
				
			<li>
				<a href="<%=rootPath %>/post/board.jsp?page=1"> Board </a>
				<ul>
					<li><a href="<%=rootPath %>/post/board.jsp?go=공지"> 공지 </a></li>
					<li><a href="<%=rootPath %>/post/board.jsp?go=일반"> 일반 </a></li>
					<li><a href="<%=rootPath %>/post/board.jsp?go=정보"> 정보 </a></li>
					<li><a href="<%=rootPath %>/post/board.jsp?go=질문"> 질문 </a></li>
				</ul>
			</li>
				
			
			<%} else {%>
			
			
			<li><a href="<%=rootPath %>/user/join.jsp"> Join </a></li>
			<li><a href="<%=rootPath %>/user/login.jsp"> Login </a></li>
			<li>
				<a href="<%=rootPath %>/post/board.jsp?page=1">Board</a>
				<ul>
					<li><a href="<%=rootPath %>/post/board.jsp?go=공지"> 공지 </a></li>
					<li><a href="<%=rootPath %>/post/board.jsp?go=일반"> 일반 </a></li>
					<li><a href="<%=rootPath %>/post/board.jsp?go=정보"> 정보 </a></li>
					<li><a href="<%=rootPath %>/post/board.jsp?go=질문"> 질문 </a></li>
				</ul>
			</li>
				
		<%} %>
		</ul>	
	</div>