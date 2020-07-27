<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메뉴 추가하기</title>
</head>
<body>
	<h1>메뉴를 추가해주세요!</h1>
	<form action="insert" method="post">
		<input type="text" name="name">
		<input type="text" name="price">
		<select name="sort">
			<option value="한식">한식</option>
			<option value="중식">중식</option>
			<option value="양식">양식</option>
			<option value="일식">일식</option>
		</select>
		<input type="submit" value="등록">
	</form>
</body>
</html>