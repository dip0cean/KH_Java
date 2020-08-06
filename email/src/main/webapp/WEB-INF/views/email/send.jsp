<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이메일을 보내보자! 스팸!! 후후</title>
</head>
<body>
	<h1>이메일 보내기</h1>
	<form action="send" method="post">
		<input type="text" name="email" placeholder="받는 이" required="required">
		<br><br>
		<input type="text" name="title" placeholder="제목" required="required">
		<br><br>
		<textarea name="text" placeholder="내용" required="required"></textarea>
		<br><br>
		<input type="submit" value="이메일 전송">
	</form>
</body>
</html>