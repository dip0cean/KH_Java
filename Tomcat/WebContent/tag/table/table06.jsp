<%@page import="tomcat.Beans.ClientDTO"%>
<%@page import="java.util.List"%>
<%@page import="tomcat.Beans.ClientDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	ClientDAO cdao = new ClientDAO();
	List<ClientDTO> list = cdao.getList();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보</title>
</head>
<body>
	<div align="center">
		<h1>회원 리스트</h1>
		<table border="1">
			<thead>
				<tr>
					<th>번호</th>
					<th>아이디</th>
					<th>패스워드</th>
					<th>등급</th>
					<th>가입일자</th>
					<th>포인트</th>
				</tr>
			</thead>
			<tbody>
				<%for(ClientDTO cdto : list) { %>
				<tr>
					<td><%=cdto.getClient_no() %></td>
					<td><%=cdto.getClient_id() %></td>
					<td><%=cdto.getClient_pw() %></td>
					<td><%=cdto.getClient_auth() %></td>
					<td><%=cdto.getClient_join() %></td>
					<td><%=cdto.getClient_point() %>점</td>
				</tr>
				<%} %>
			</tbody>
		</table>
	</div>
</body>
</html>