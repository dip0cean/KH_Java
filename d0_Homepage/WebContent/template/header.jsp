<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>놀러와용! 성헌의 숲!</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/base.css">
<style type="text/css">

	main {
		width: 1038px;
		margin: auto;
		font-family: D2Coding;
	}


a:link { color: green; text-decoration: none;}
a:visited { color: green; text-decoration: none;}
a:hover { color: bisque; text-decoration: none;}
	
</style>
</head>
<body test>
	<!-- 화면 배치는 테이블로 하면 안되지만 빠른 구현을 위해 테이블로 하고, 추후에 div로 교체 -->
	<main>
		<header>
			<div align="center">
				<a href="<%=request.getContextPath()%>"><img alt="로고" src="<%=request.getContextPath()%>/image/동숲로고.png" width="150" height="150"></a>
			</div>
		</header>
		
		<nav>
			<jsp:include page="/template/navi.jsp"></jsp:include>
		</nav>
		<section>
		
