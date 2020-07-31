<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 메인 페이지</title>
<style>
	body {
		text-align: center;
	}
	
	#nav {
		display: flex;
		height: 150px;
		border-bottom: 3px solid black;
	}
	#nav>div {
		flex: 1;
	}
</style>
</head>
<body>
	<header>
		<h1>상품 메인 페이지</h1>
	</header>
	<nav>
		<div id="nav">
			<div><a href="">메인</a></div>
			<div><a href="add">상품 등록</a></div>
			<div><a href="list">상품 리스트</a></div>
		</div>
	</nav>
	<article>
		환영합니다~
	</article>
</body>
</html>