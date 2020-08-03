<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사진 등록 페이지</title>
<style>
	body {
		text-align: center;
	}
</style>
</head>
<body>
<h1>사진 등록</h1>
	<form action="insert" method="post" enctype="multipart/form-data">
		<div>
			<span>사진 이름</span>
			<input type="text" name="title" placeholder="사진 이름을 입력해주세요!">
		</div>
		<br><br>
		<div>
			<span>사진 내용</span>
			<input type="text" name="explain" placeholder="사진 설명을 입력해주세요!">
		</div>
		<br><br>
		<div>
			<span>사진 등록</span>
			<input type="file" name="f" multiple="multiple" accept=".jpg, .png, .gif">
		</div>
		<br><br>
		<div>
			<input type="submit" value="등록">
		</div>
	</form>
</body>
</html>