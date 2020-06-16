<%@page import="java.util.Enumeration"%>
<%@page import="java.util.List"%>
<%@page import="homepage.beans.dto.PostDTO"%>
<%@page import="homepage.beans.dao.PostDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	List<PostDTO> list;
	PostDAO pdao = new PostDAO();
	PostDTO pdto = new PostDTO();
	Enumeration<String> e = request.getParameterNames();
	String parameterName = (String) e.nextElement();
	String keyword;

	if(parameterName.equals("post_id")){
		
	 list = pdao.userPost(request.getParameter("post_id"));
	 keyword = request.getParameter("post_id");
		
	} else if(request.getParameter("post_sub").equals("post_id")){
		
		list = pdao.searchId_post(request.getParameter("post_title"));
		keyword = request.getParameter("post_title");
		
	} else {
		
	pdto.setPost_sub(request.getParameter("post_sub"));
	pdto.setPost_title(request.getParameter("post_title"));
	list = pdao.searchPost(pdto);
	keyword = request.getParameter("post_title");
	
	}
	
	
%>


<jsp:include page="/template/header.jsp"></jsp:include>
<div align="center">
	<h2>"<%=keyword %>" 로 검색한 결과</h2>
	<h3>총 <%=list.size() %> 건의 게시글이 있습니다.</h3>
	<hr>
	
	<table>
		<thead>
			<tr><td colspan="6"><hr></td></tr>
			<tr>
				<th width="60">번호</th>
				<th>말머리</th>
				<th width="500">제목</th>
				<th width="80">작성자</th>
				<th>조회수</th>
				<th width="150">작성일</th>
			</tr>
		</thead>
		<tbody>
			<%if(list.isEmpty()) { %>
			<tr height="40">
				<th colspan="6">
					<i><b>게시글을 조회할 수 없습니다.</b></i>
				</th>
			</tr>	
			<%} else {%>
				<%for(PostDTO post : list) {%>
						<tr height="40">
							<td align="center"><%=post.getPost_no() %></td>
							<td align="center"><%=post.getPost_sub() %></td>
							<td><a href="post.jsp?post_no=<%=post.getPost_no() %>"><%=post.getPost_title() %></a></td>
							<td align="center"><a href="postList.jsp?post_id=<%=post.getPost_id()%>"><%=post.getPost_id() %></a></td>
							<td align="center"><%=post.getPost_hits() %></td>
							<td><%=post.getPost_date() %></td>		
						</tr>
				<%} %>
			<%} %>	
		</tbody>
		<tfoot>
			<tr>
				<td colspan="6" align="center">
				<hr><br>
				<form action="search.jsp" method="post">
					<select name="post_sub">
						<option disabled="disabled">선택</option>
						<option value="공지">공지</option>
						<option value="일반" selected="selected">일반</option>
						<option value="정보">정보</option>
						<option value="질문">질문</option>
						<option value="post_id">아이디</option>
					</select>
					<input type="text" name="post_title" placeholder="제목">
					<input type="submit" value="검색">
				</form>
				<br>
					<a href="create.jsp"><input type="button" value="글쓰기"></a>
					<a href="board.jsp"><input type="button" value="목록으로"></a>
				</td>
			</tr>
		</tfoot>
	</table>
	
</div>

<jsp:include page="/template/footer.jsp"></jsp:include>