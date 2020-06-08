<%@page import="tomcat.Beans.StudentDTO"%>
<%@page import="tomcat.Beans.StudentDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생 점수 등록</title>
</head>
<body>
	<div align="center">
		<h1>학생 점수 등록</h1>
		<form action="/Tomcat/student/regist.do">
			<table>
				<tbody>
					<tr>
						<th>이름</th>
						<td><input type="text" name="student_name" placeholder="이름"></td>
					</tr>
					<tr>
						<th>점수</th>
						<td><input type="number" name="student_score"
							placeholder="점수"></td>
					</tr>
					<tr>
						<th colspan="2"><input type="submit" value="등록"></th>
					</tr>
				</tbody>
			</table>
		</form>
	</div>

</body>
</html>