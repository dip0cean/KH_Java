<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세 게시글</title>
</head>
<body>
	<table border="1">
		<thead>
			<tr>
				<th>말머리</th>
				<th>제목</th>
				<th>작성자</th>
				<th>내용</th>
				<th>조회수</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>${boardDetail.board_head }</td>
				<td>${boardDetail.board_title }</td>
				<td>${boardDetail.board_writer }</td>
				<td>${boardDetail.board_content }</td>
				<td>${boardDetail.board_read }</td>
			</tr>
		</tbody>
	</table>
	<a href="union"><button>돌아가기</button></a>
	<c:choose>
		<c:when test="${memberLogin.member_id == boardDetail.board_writer}">
			<form action="delete" method="post" style="display: inline-block;">
				<input type="hidden" name="board_writer" value="${boardDetail.board_writer }">
				<input type="hidden" name="board_no" value="${boardDetail.board_no }">
				<input type="submit" value="게시글 삭제">
			</form>
		</c:when>
	</c:choose>
</body>
</html>