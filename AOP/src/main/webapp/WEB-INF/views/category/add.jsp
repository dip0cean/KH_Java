<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>I카테고리 추가하기</title>
</head>
<body>
	<h1>카테고리 추가하기!</h1>
	<form action="add" method="post">
		<input type="text" name="c_no" placeholder="카테고리 번호">
		<input type="text" name="c_name" placeholder="카테고리 이름">
		<input type="submit" value="등록">
	</form>
</body>
</html>