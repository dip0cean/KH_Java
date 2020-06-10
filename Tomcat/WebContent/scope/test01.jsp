<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	int a = 10;

	session.setAttribute("b", 20);

	application.setAttribute("c", 30);
%>

<h1>
	a =
	<%=a%></h1>
<h1>
	b =
	<%=session.getAttribute("b")%></h1>

<h1>
	c =
	<%=application.getAttribute("c")%></h1>

<h2>
	session =
	<%=session.getId()%></h2>
