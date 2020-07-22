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
		저장소별로 저장된 데이터에 접근하기 위한 EL 코드
		- request : requestScope
		- session : sessionScope
		- application : applicationScope
	 --%>
	
	<%
		// 서블릿이라 생각하고 첨부코드를 작성
		request.setAttribute("a", 100);
	
		// 세션에 데이터를 추가
		session.setAttribute("id", "admin");
	%>
	<!-- requestScope > req 내에 있는 내장 객체를 불러오는 명령어 > 생략 가능 -->
	<h1>a = ${requestScope.a }</h1>
	<h1>a = ${a }</h1>
	
	<!-- session 내장 객체 불러오기 -->
	<h1>기존의 방식 > id = <%=session.getAttribute("id") %></h1>
	<h1>sessionScope > id = ${sessionScope.id }</h1>
	<h1>sessionScope 생략 > id = ${id }</h1>
	
	<!-- 
		만약 세션에 저장된 auth 라는 항목이 '관리자' 라면 true, 아니면 false 
		- 자바에서는 null 인 경우를 고려하면서 식을 작성해야 함.
	-->
	<h1>권한 : <%=session.getAttribute("auth") != null && session.getAttribute("auth").equals("관리자") %></h1>
	<h1>권한 : ${auth == "관리자" }</h1>
</body>
</html>