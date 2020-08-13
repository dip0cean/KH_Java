<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 결제 요청</title>
</head>
<body>
	<h1>결제 페이지</h1>
	<form action="payment" method="post">
		<input type="text" name="item_name" placeholder="상품 이름">
		<input type="number" name="quantity" placeholder="상품 개수">
		<input type="number" name="total_amount" placeholder="상품 총 가격">
		<input type="submit" value="결제 요청"> 	
	</form>
	
</body>
</html>