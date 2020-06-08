<%@page import="tomcat.Beans.StudentDTO"%>
<%@page import="java.util.List"%>
<%@page import="tomcat.Beans.StudentDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!--  목표 > test01 + test02 -->
<%
	// JSP 에서는 HttpServletRequest 를 request 라는 내장객체로 관리한다.
	String q = request.getParameter("q");
	StudentDAO sdao = new StudentDAO();
	List<StudentDTO> list = sdao.getSearch(q);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생 검색</title>
</head>
<body>
	<div align="center">
		<h1>학생 검색</h1>

		<form action="test03.jsp">
			<input type="text" name="q" value="<%=q%>">
			<input type="submit" value="검색">
		</form>

		<h5>
			검색 결과 :
			<%=list.size()%>
			개
		</h5>

		<table border="1">
			<thead>
				<tr>
					<th>번호</th>
					<th>이름</th>
					<th>성적</th>
					<th>등록일</th>
				</tr>
			</thead>
			<tbody>
				<%
					for (StudentDTO sdto : list) {
				%>
				<tr>
					<td><%=sdto.getStudent_no()%></td>
					<td align="center" width="80"><%=sdto.getStudent_name()%></td>
					<td align="center"><%=sdto.getStudent_score()%>점</td>
					<td><%=sdto.getStudent_create()%></td>
				</tr>
				<%
					}
				%>
			</tbody>
		</table>
	</div>

</body>
</html>