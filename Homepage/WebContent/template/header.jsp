<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>놀러와용! 성헌의 숲!</title>
<link rel="stylesheet" type="text/css" href="base.css">
<style type="text/css">
a:link { color: green; text-decoration: none;}
a:visited { color: green; text-decoration: none;}
a:hover { color: skyblue; text-decoration: none;}
	
	.navi,
	.navi ul {
		padding: 0px;
		margin: 0px;
		list-style: none;
		cursor: pointer;
	}
	
	.navi li {
		width: 200px;
		padding: 0.4rem;
		position: relative;
	}
	
	.navi>li {
		display: inline-block;
	}
	
	.navi li:hover {
		background-color: springgreen;
	}
	
	.navi>li ul {
		position: absolute;
		top: 100%;
		left: 0px;
	}
	
	.navi>li ul {
		display: none;
	}
	
	.navi>li:hover>ul {
		display: block;
		opacity: 0.5;
	}
	
	.navi a {
		font-size: 34px;
		text-decoration: none;
		color: gray;
	}
</style>
</head>
<body test>
	<!-- 화면 배치는 테이블로 하면 안되지만 빠른 구현을 위해 테이블로 하고, 추후에 div로 교체 -->
	<div align="center">
		<table>
			<tbody>
				<!-- header -->
				<tr height="150">
					<td align="center">
						<a href="<%=request.getContextPath()%>"><img alt="로고" src="/Homepage/image/동숲로고.png" width="150" height="150"></a>
					</td>
				</tr>
				
				<!-- navigation -->
				<tr>
					<td align="center">
				<jsp:include page="/template/navi.jsp"></jsp:include>
									
					</td>
				</tr>
				
				<!-- section -->
				<tr height="350">
					<td valign="top">