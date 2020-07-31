<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 수정</title>
<style>
	body {
		text-align: center;
	}
</style>
</head>
<body>
	<h1>상품 수정 페이지</h1>
	<form action="edit" method="post">
		<input type="hidden" name="no" value="${product.no }">
		<div>
			<div>
				<span>상품 이름</span>
				<input type="text" name="name" value="${product.name }" placeholder="이름">
				<br><br>
			</div>
			<div>
				<span>상품 가격</span>
				<input type="text" name="price" value="${product.price }" placeholder="가격"> 원
				<br><br>
			</div>
			<div>
				<span>상품 분류</span>
				<select name="type">
					<option>여상 상의</option>
					<option>여성 하의</option>
					<option>여성 잡화</option>
					<option>남성 상의</option>
					<option>남성 하의</option>
					<option>남성 잡화</option>
				</select>
				<br><br>
			</div>
			<div>
				<input type="submit" value="수정">
			</div>
		</div>
	</form>
</body>
</html>