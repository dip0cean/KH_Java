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
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>${boardDetail.board_head }</td>
				<td>${boardDetail.board_title }</td>
				<td>${boardDetail.board_writer }</td>
				<td>${boardDetail.board_content }</td>
			</tr>
		</tbody>
	</table>
	<a href="union"><button>돌아가기</button></a>
</body>
</html>