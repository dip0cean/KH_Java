<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입 페이지</title>

</head>
<body>
	<h1>회원 가입</h1>
	<form action="join" method="post">
		<span>이메일</span> <input type="text" value="${param.email }" name="email" readonly="readonly">
		<input type="submit" value="회원 가입">
	</form>
</body>
</html>