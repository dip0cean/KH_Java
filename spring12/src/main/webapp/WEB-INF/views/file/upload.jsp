<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일 업로드</title>
</head>
<body>
	<h1>파일 업로드를 해보자꾸나</h1>

	<form action="upload" method="post" enctype="multipart/form-data">

		<input type="text" name="uploader"> <br>
		<br> <input type="file" name="f" multiple="multiple" accept=".jpg, .png, .gif"> <br>
		<br> <input type="submit" value="업로드">

	</form>
</body>
</html>