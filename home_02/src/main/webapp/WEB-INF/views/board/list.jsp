<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 전체 리스트</title>
</head>
<body>
	<h1>게시글 리스트</h1>
	<form action="union" method="post">
		<select name="type">
			<option value="board_title">제목</option>
			<option value="board_writer">작성자</option>
		</select>
		<input type="text" name="keyword" placeholder="검색어를 입력해주세요." value="${param.keyword }">
		<input type="submit" value="검색">
	</form>
	<a href="write"><button>게시글 작성</button></a>
	<c:choose>
		<c:when test="${not empty list }">
			<table border="1">
				<thead>
					<tr>
						<th>번호</th>
						<th>말머리</th>
						<th>제목</th>
						<th>작성자</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="board" items="${list }">
						<tr>
							<td>${board.board_no }</td>
							<td>${board.board_head }</td>
							<td><a href="detail?board_no=${board.board_no }">${board.board_title }</a></td>
							<td>${board.board_writer }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:when>
		<c:otherwise>
			<h3>게시글이 없습니다.</h3>
		</c:otherwise>
	</c:choose>
</body>
</html>