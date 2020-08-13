<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결제 취소</title>
</head>
<body>
	<h1>결제 취소!</h1>
	<h2>주문 번호 : ${cancel.tid }</h2>
	<h2>제품명 : ${cancel.item_name }</h2>
	<h2>취소 개수 : ${cancel.quantity }</h2>
	<h2>취소 금액 : ${cancel.amount.total }</h2>
</body>
</html>