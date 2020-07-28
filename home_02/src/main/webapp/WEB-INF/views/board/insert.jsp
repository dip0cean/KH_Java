<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 등록</title>
</head>
<body>
	<form action="insert" method="post">
		<select name="board_head">
			<option>공지</option>
			<option>유머</option>
			<option>정보</option>
		</select>
		<input type="text" name="board_title" placeholder="제목">
		<input type="text" name="board_writer" placeholder="아이디">
		<textarea rows="100" cols="100" placeholder="게시글 내용" name="board_content"></textarea>
		<input type="submit" value="게시글 내용 입력">
	</form>
</body>
</html>