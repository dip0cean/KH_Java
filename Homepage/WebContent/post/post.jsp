<%@page import="homepage.beans.dao.PostDAO"%>
<%@page import="homepage.beans.dto.MemberDTO"%>
<%@page import="homepage.beans.dto.PostDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%

	PostDAO pdao = new PostDAO();
	PostDTO pdto = pdao.getPost(Long.parseLong(request.getParameter("post_no")));
	long hits = pdao.getHits(pdto);
	String post_id = pdto.getPost_id();
	
	MemberDTO mdto = (MemberDTO) session.getAttribute("userinfo");
	String member_id = mdto.getMember_id();
	
%>

<jsp:include page="/template/header.jsp"></jsp:include>

<div align="center">
	<h2><%=pdto.getPost_title() %></h2>
	<table border="1">
		<thead>
			<tr>
				<th height="80">말머리</th>
				<td><%=pdto.getPost_sub() %></td>
				<th height="80">작성자</th>
				<td><%=pdto.getPost_id() %></td>
			</tr>
			<tr>
				<th height="80">제목</th>
				<td colspan="4"><font size="5"><%=pdto.getPost_title() %></font></td>
			</tr>
		</thead>
		<tbody>
			<tr>
				<th height="450">내용</th>
				<td width="600" height="450" colspan="4"><%=pdto.getPost_content() %></td>
			</tr>
		</tbody>
		<tfoot>
			<tr>
				<th height="80">조회수</th>
				<td><%=hits %></td>
				<th height="80">작성일</th>
				<td><%=pdto.getPost_date() %>
			</tr>
		</tfoot>
	</table>
	<br>
	<a href="board.jsp"><input type="button" value="뒤로 가기"></a>
	<%if(post_id.equals(member_id)) { %>
		<a href="edit_post.jsp?post_no=<%=pdto.getPost_no()%>"><input type="button" value="수정"></a>
		<a href="delete.do?post_no=<%=pdto.getPost_no()%>"><input type="button" value="삭제"></a>
	<%} %>
</div>

<jsp:include page="/template/footer.jsp"></jsp:include>

