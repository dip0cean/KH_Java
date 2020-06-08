<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="tomcat.Beans.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	//	StudentDAO 선언 > getList 메소드 호출.
	//	JSP 에서는 기본적으로 예외처리가 되어 있기 때문에 try 문 사용 하지 않아도 됨.
	StudentDAO sdao = new StudentDAO();
	List<StudentDTO> list = sdao.getList();
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생 목록</title>
</head>
<body>
	<div align="center">
		<h1>학생 목록</h1>
		<table border="1">
			<thead>
				<tr>
					<th>번호</th>
					<th>이름</th>
					<th>점수</th>
					<th>등록일</th>
				</tr>
			</thead>
			<tbody>
				<% for (StudentDTO sdto : list) { %>
				<tr>
					<td><%=sdto.getStudent_no() %></td>
					<td align="center" width="80"><a href="/Tomcat/tag/form/student01.jsp?no=<%=sdto.getStudent_no()%>"><%=sdto.getStudent_name() %></a></td>
					<td align="center"><%=sdto.getStudent_score() %>점 </td>
					<td><%=sdto.getStudent_create() %></td>
				</tr>
				<% } %>
			</tbody>
		</table>
	</div>
</body>
</html>