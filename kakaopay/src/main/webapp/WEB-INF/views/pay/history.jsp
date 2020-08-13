<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>현재 결제 조회</title>
</head>
<body>
	<h1>${not empty result.item_name}</h1>
	<h2>주문 번호 : ${result.tid }</h2>
	<h2>제품 이름 : ${result.item_name }</h2>
	<h2>제품 개수 : ${result.quantity } 개</h2>
	<h2>제품 가격 : ${result.amount.total } 원</h2>
	
	<a href="cancel?tid=${result.tid}&cancel_amount=${result.amount.total}&cancel_tax_free_amount=${result.amount.tax_free}"><button>결제 취소하기</button></a>
</body>
</html>