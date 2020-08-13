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
	<h2>${result.tid }</h2>
	<h2>${result.item_name }</h2>
</body>
</html>