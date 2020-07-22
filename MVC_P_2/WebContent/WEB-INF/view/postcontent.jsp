<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물을 찾아보자!</title>
<style>
	h3 {
		display: inline-block;
		width: 250px;
	}
</style>
</head>
<body>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<c:set var="path" value="${pageContext.request.contextPath }"></c:set>
	<form action="${path }/postcontent.do">
		<input type="text" name="post_no" placeholder="게시글 번호" value="${param.post_no }">
		<input type="submit" value="전송">
	</form>
		<c:forEach var="post_content" items="${post }">
			<h3>번호 : ${post_content.post_no }</h3>
			<h3>제목 : ${post_content.post_title }</h3>
			<h3 style="color: pink;">작성자 : ${post_content.post_id }</h3>
			
			<c:if test="${not empty param.post_no }">
				<p>내용 : ${post_content.post_content }
					<c:if test="${post_content == null }">
						게시글을 찾을 수 없습니다.
					</c:if>
				</p>
				<form action="${path }/postcontent.do">
					<input type="submit" value="홈으로">
				</form>
			</c:if>
			<hr>
		</c:forEach>

</body>
</html>