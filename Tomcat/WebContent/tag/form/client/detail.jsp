<%@page import="tomcat.Beans.ClientDTO"%>
<%@page import="java.util.List"%>
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
<title>회원 상세 정보</title>
</head>
<body>
	<div align="center">
		<h1>
			<a href="list.jsp">회원 상세 정보</a>
		</h1>
		<table border="1">
			<thead>
				<tr>
					<th>번호</th>
					<th>아이디</th>
					<th>등급</th>
					<th>가입일</th>
					<th>포인트</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><%=cdto.getClient_no()%></td>
					<td><%=cdto.getClient_id()%></td>
					<td><%=cdto.getClient_auth()%></td>
					<td><%=cdto.getClient_join()%></td>
					<td><%=cdto.getClient_point()%></td>
				</tr>
			</tbody>
		</table>
	</div>
</body>
</html>