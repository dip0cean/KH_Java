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
	<fo    rm action="union" method="post">
		<select name="type">
			<option value="board_title">제목</option>
			<option value="boatd_writer">작성자</option>
		</select>
		<input type="text" name="keyword" placeholder="검색어를 입력해주세요." value="${param.keyword }">
		<input type="submit" value="검색">
	</form>
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
							<td>${board.board_title }</td>
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