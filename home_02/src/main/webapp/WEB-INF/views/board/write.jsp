<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 등록</title>
</head>
<body>
	<form action="write" method="post">
		<div>
			<select name="board_head">
				<option>공지</option>
				<option>유머</option>
				<option>정보</option>
			</select>
			<input type="text" name="board_title" placeholder="제목">
		</div>
		<div>
			<input type="hidden" name="board_writer" value="${memberLogin.member_id }" placeholder="아이디">
		</div>
			<div>
		<textarea rows="30" cols="100" placeholder="게시글 내용" name="board_content"></textarea>
			</div>
		<div>
			<input type="submit" value="게시글 내용 입력">
		</div>
	</form>
</body>
</html>