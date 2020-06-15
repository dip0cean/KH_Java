<%@page import="homepage.beans.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%
	String rootPath = request.getContextPath();
	MemberDTO mdto = (MemberDTO)session.getAttribute("userinfo"); 
	boolean isLogin = mdto != null;
%>

<div>

	<%if(isLogin) {%>
	
		<font size="5" color="black">
		
			<a href="<%=rootPath %>/member/logout.do"> Logout </a>
			<a href="<%=rootPath %>/member/mypage.jsp"> My page </a>
			
			<!-- 관리자 계정일 경우 -->
			<%if(mdto.getAccess_auth().equals("운영자")) { %>
			
			<a href="<%=rootPath %>/admin/home.jsp"> Setting </a>
			
			<%} %>
			
			<a href="<%=rootPath %>/post/board.jsp"> Board </a>	
			
		</font>
		
		<%} else {%>
		
		<font size="5" color="black">
		
			<a href="<%=rootPath %>/user/join.jsp"> Join </a>
			<a href="<%=rootPath %>/user/login.jsp"> Login </a>
			<a href="<%=rootPath %>/post/board.jsp">Board</a>
			
		</font>
		
	<%} %>
	
</div>