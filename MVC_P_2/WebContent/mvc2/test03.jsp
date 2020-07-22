<%@page import="mvc.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%--
		EL > 객체(DTO) 접근
	 --%>

	<%
		MemberDTO mdto = new MemberDTO();
		mdto.setId("user");
		mdto.setPw("user11");

		request.setAttribute("user", mdto);
	%>

	<!-- 출력 -->
	<%-- 	 <h1>아이디 : <%=((MemberDTO)request.getAttribute("mdto")).getId() %></h1> --%>
	
	<!-- 전체 코드 -->
	
	<h1>아이디 : ${requestScope.user.getId() }</h1>	
	
	<!-- 1차 압축 코드 -->
	
	<h1>비밀번호 : ${user.getPw() }</h1>
	
	<!-- 2차 압축 코드 -->
	<h1>아이디 / 비밀번호 : ${user.id } / ${user.pw }</h1>
</body>
</html>