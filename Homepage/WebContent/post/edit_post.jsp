<%@page import="java.util.List"%>
<%@page import="homepage.beans.dao.PostFileDAO"%>
<%@page import="homepage.beans.dto.PostFileDTO"%>
<%@page import="homepage.beans.dto.PostDTO"%>
<%@page import="homepage.beans.dao.PostDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	PostDAO pdao = new PostDAO();
	PostDTO pdto = pdao.getPost(Long.parseLong(request.getParameter("post_no")));
%>

<jsp:include page="/template/header.jsp"></jsp:include>

<div align="center">
	<h2>게시글 수정</h2>
	<form action="edit_post.do" method="post">
		<table>
			<tr><td><input type="hidden" name="post_no" value="<%=pdto.getPost_no() %>"></td></tr>
			<tr>
				<th>말머리</th>
				<td><select name="post_sub">
						<option disabled="disabled">선택</option>
						<option value="공지">공지</option>
						<option value="일반" selected="selected">일반</option>
						<option value="정보">정보</option>
						<option value="질문">질문</option>
				</select></td>
			</tr>
			<tr>
				<th>작성자</th>
				<td><%=pdto.getPost_id()%></td>
				<td><input type="hidden" name="post_id"
					value="<%=pdto.getPost_id()%>"></td>
			</tr>
			<tr>
				<th>제목</th>
				<td><input type="text" name="post_title" size="70"
					maxlength="100" value="<%=pdto.getPost_title() %>"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea rows="30" cols="70" name="post_content"><%=pdto.getPost_content() %></textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="수정">
				</td>
			</tr>
		</table>
	</form>
</div>

<jsp:include page="/template/footer.jsp"></jsp:include>
