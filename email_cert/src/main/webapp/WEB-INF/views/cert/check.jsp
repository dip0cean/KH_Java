<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>인증번호 입력</title>
</head>
<body>	
	<h1>인증번호 입력</h1>
	<form action="check" method="post">
		<input type="text" name="secret" placeholder="인증번호">
		<input type="submit" value="인증하기">	
	</form>
</body>
</html>