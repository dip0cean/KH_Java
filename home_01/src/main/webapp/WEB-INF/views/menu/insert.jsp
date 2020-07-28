<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메뉴를 추가해보자~</title>
</head>
<body>
	<form action="insert" method="post">
		<input type="text" name="name" placeholder="메뉴">
		<input type="text" name="price" placeholder="가격">
		<select name="sort">
			<option>한식</option>
			<option>중식</option>
			<option>양식</option>
			<option>일식</option>
		</select>
		<input type="submit" value="등록">
	</form>
</body>
</html>