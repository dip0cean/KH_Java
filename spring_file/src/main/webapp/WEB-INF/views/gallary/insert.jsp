<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>갤러리 이미지</title>
</head>
<body>
	<h1>사진 등록하기</h1>
	<form action="insert" method="post" enctype="multipart/form-data">
		<input type="text" name="title">
		<input type="text" name="explain">
		<input type="file" name="f" accept=".jpg, .png, .gif">
		<input type="submit" value="등록하기">
	</form>
</body>
</html>