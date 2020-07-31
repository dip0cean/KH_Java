<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일 업로드</title>
</head>
<body>
<form action="upload" method="post" enctype="multipart/form-data">

	<input type="text" name="uploader">
	<br><br>
	<input type="file" name="f">
	<br><br>
	<input type="submit" value="업로드">

</form>
</body>
</html>