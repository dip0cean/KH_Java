<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CLASS 101 | 회원가입</title>
</head>
<body>
	<h1>회원가입을 진행합니다.</h1>
	<form action="join" method="post">
		<span>아이디</span>
			<input type="text" name="id">
			<br>
		<span>비밀번호</span>	
			<input type="password" name="pw">
			<br>
		<span>닉네임</span>	
			<input type="text" name="nick">
			<br>
			<input type="submit" value="회원가입">
	</form>
</body>
</html>