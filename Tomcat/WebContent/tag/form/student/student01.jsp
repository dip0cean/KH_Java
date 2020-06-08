<%@page import="tomcat.Beans.StudentDTO"%>
<%@page import="tomcat.Beans.StudentDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	int student_no = Integer.parseInt(request.getParameter("no"));
	StudentDAO sdao = new StudentDAO();
	StudentDTO sdto = sdao.get(student_no);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생 상세 정보</title>
</head>
<body>
	<div align="center">
		<h1>학생 상세 정보</h1>

		<table border="1">
			<tr>
				<th>번호</th>
				<td><%=sdto.getStudent_no()%></td>
			</tr>
			<tr>
				<th>이름</th>
				<td><%=sdto.getStudent_name()%></td>
			</tr>
			<tr>
				<th>점수</th>
				<td><%=sdto.getStudent_score()%></td>
			</tr>
			<tr>
				<th>등록일</th>
				<td><%=sdto.getStudent_create()%></td>
			</tr>
		</table>
	</div>
</body>
</html>