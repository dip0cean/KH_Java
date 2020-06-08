<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	Calendar cal = Calendar.getInstance();
	int birth_year = cal.get(Calendar.YEAR);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>생년월일 선택</title>
</head>
<body>
	<div align="center">
		<h1>생년월일을 선택해주세요.</h1>	
		<form>
			<!-- 년도 -->
			<select name="year" required>
				<option value="">연도</option>
				<%for (int i = birth_year; i >= 1900; i--) {%>
				<option><%=i%></option>
				<%}%>
			</select>
			
			<!-- 월 -->
			<select name="month" required>
				<option value="">월</option>
				<%for (int i = 1; i <= 12; i++) {%>
				<option><%=i%></option>
				<%}%>
			</select>
			
			<!-- 일 -->
			<select name="date" required>
				<option value="">일</option>
				<%for (int i = 1; i <= 31; i++) {%>
				<option><%=i%></option>
				<%}%>
			</select>
			
			<input type="submit" value="전송">
		</form>
	</div>
</body>
</html>