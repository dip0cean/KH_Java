<%@page import="java.util.List"%>
<%@page import="homepage.beans.dto.PostDTO"%>
<%@page import="homepage.beans.dao.PostDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%
	PostDAO pdao = new PostDAO();
	List<PostDTO> list;
	String go = request.getParameter("go");
	if(request.getParameter("go") != null) {
		list = pdao.boardPost(go);
	} else {
		go = "전체";
		list = pdao.fullPost();
	}
%>	

<jsp:include page="/template/header.jsp"></jsp:include>

<div align="center">
	<h2><%=go %> 게시판</h2>
	<table>
		<thead>
			<tr>
				<th><a href="board.jsp">전체</a></th>
				<th><a href="board.jsp?go=공지">공지</a></th>
				<th><a href="board.jsp?go=일반">일반</a></th>
				<th><a href="board.jsp?go=정보">정보</a></th>
				<th><a href="board.jsp?go=질문">질문</a></th>
			</tr>
		</thead>
	</table>
	
	<br>
	
	<table style="width: 1038px;">
		<thead>
			<tr><td colspan="6"><hr></td></tr>
			<tr>
				<th width="70">번호</th>
				<th width="100">말머리</th>
				<th width="500">제목</th>
				<th width="200">작성자</th>
				<th width="150">조회수</th>
				<th width="150">작성일</th>
			</tr>
		</thead>
		<tbody>
			<%if(list.isEmpty()) { %>
			<tr>
				<th colspan="6">
					<i><b>게시글을 조회할 수 없습니다.</b></i>
				</th>
			</tr>	
			<%} else {%>
				<%for(PostDTO pdto : list) {%>
						<tr height="40">
							<td align="center"><%=pdto.getPost_no() %></td>
							<td align="center"><%=pdto.getPost_sub() %></td>
							<td><a href="post.jsp?post_no=<%=pdto.getPost_no() %>"><%=pdto.getPost_title() %></a></td>
							<%if(pdto.getPost_id() != null) { %>
							<td align="center"><a href="<%=request.getContextPath() %>/member/userinfo.jsp?member_id=<%=pdto.getPost_id()%>&go=<%=request.getContextPath()%>/post/board.jsp"><%=pdto.getPost_id() %></a></td>
							<%}  else {%>
								<td align="center"><font color="gray" size="2"><i>탈퇴한 유저</i></font></td>
							<%} %>
							<td align="center"><%=pdto.getPost_hits() %></td>
							<td><%=pdto.getPost_date2() %></td>			
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
				</td>
			</tr>
		</tfoot>
	</table>
	<br>
</div>

<jsp:include page="/template/footer.jsp"></jsp:include>