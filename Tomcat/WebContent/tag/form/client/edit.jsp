<%@page import="tomcat.Beans.ClientDTO"%>
<%@page import="tomcat.Beans.ClientDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int no = Integer.parseInt(request.getParameter("no"));
	ClientDAO cdao = new ClientDAO();
	ClientDTO cdto = cdao.get(no);
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>패스워드 변경</title>
</head>
<body>
	<div align="center">
		<h1>패스워드 변경</h1>
		<form action="/Tomcat/client/edit.do">
			<input type="text" name="id" placeholder="아이디" value=<%=cdto.getClient_id() %>><br> <br>
			<input type="password" name="pw" placeholder="기존 패스워드"><br> <br>
			<input type="password" name="edit_pw" placeholder="새로운 패스워드"><br> <br>
			<input type="submit" value="변경">
		</form>
	</div>

</body>
</html>