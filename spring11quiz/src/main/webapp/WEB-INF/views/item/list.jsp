<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 리스트</title>
<style>
	body {
		text-align: center;
	}

	#table {
		width: 100%;
	}
</style>
</head>
<body>
	<h1>상품 리스트</h1>
	<a href="/quiz/item"><button>메인으로</button></a>
	<a href="add"><button>상품 등록</button></a>
	<form action="list" method="post">
		<select name="type">
			<option value="no">번호</option>
			<option value="name">이름</option>
			<option value="type">분류</option>
		</select>
		<input type="text" name="keyword" placeholder="검색어를 입력하세요">
		<input type="submit" value="검색">
	</form>
	<hr>
	<br><br>
	<table border="1" id="table">
		<thead>
			<tr>
				<th>번호</th>
				<th>분류</th>
				<th>이름</th>
				<th>가격</th>
				<th>등록일</th>
				<th>수정 / 삭제</th>
			</tr>
		</thead>
		<tbody>
			<c:choose>
				<c:when test="${not empty list }">
					<c:forEach var="product" items="${list }">
						<tr>
							<td>${product.no }</td>
							<td>${product.type }</td>
							<td>${product.name }</td>
							<td>${product.price } 원</td>
							<td>${product.when }</td>
							<td><a href="edit?no=${product.no }"><button>수정</button></a> <a href="delete?no=${product.no }"><button>삭제</button></a></td>
						</tr>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<tr>
						<td>상품이 없습니다.</td>
					</tr>
				</c:otherwise>
			</c:choose>
		</tbody>
	</table>
</body>
</html>