<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생 등록 페이지</title>
</head>
<body>
	<h1>학생을 등록해주세요.</h1>
	<form action="regist" method="post">
		<input type="text" name="name" placeholder="이름">
		<input type="text" name="age" placeholder="나이">
		<input type="text" name="score" placeholder="점수">
		<input type="submit" value="등록">
	</form>
</body>
</html>