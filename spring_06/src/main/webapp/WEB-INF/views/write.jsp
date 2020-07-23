<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="post" method="post">
		<span>제목</span>
			<input type="text" name="title">
		<span>내용</span>
			<textarea name="content" placeholder="내용을 입력해주세요."></textarea>
		<input type="submit" value="게시글 등록">
	</form>
</body>
</html>