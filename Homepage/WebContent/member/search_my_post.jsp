<%@page import="homepage.beans.dto.MemberDTO"%>
<%@page import="homepage.beans.dao.MemberDAO"%>
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
		// 마이 페이지에서 작성글 조회 시
		 list = pdao.userPost(request.getParameter("post_id"));
		 keyword = request.getParameter("post_id");
		
	} else if(request.getParameter("post_sub").equals("post_id")){
		// 전체 게시판에서 아이디로 검색 시
		list = pdao.searchId_post(request.getParameter("post_title"));
		keyword = request.getParameter("post_title");
		
	} else {
		// 전체 게시판에서 제목 및 말머리로 검색 시
		pdto.setPost_sub(request.getParameter("post_sub"));
		pdto.setPost_title(request.getParameter("post_title"));
		list = pdao.searchPost(pdto);
		keyword = request.getParameter("post_title");
	
	}
	
	MemberDTO mdto = (MemberDTO) session.getAttribute("userinfo");
	boolean login = mdto != null;
%>


<jsp:include page="/template/header.jsp"></jsp:include>
<div align="center">
	<h2>"<%=keyword %>" 로 검색한 결과</h2>
	<h3>총 <%=list.size() %> 건의 게시글이 있습니다.</h3> 
	
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
			
							<%if(post.getPost_id() != null) { %>
			
								<td align="center"><a href="<%=request.getContextPath() %>/member/userinfo.jsp?member_id=<%=post.getPost_id()%>"><%=post.getPost_id() %></a></td>
				
							<%}  else {%>
				
								<td align="center"><font color="gray" size="2"><i>탈퇴한 유저</i></font></td>
				
							<%} %>
				
							<td align="center"><%=post.getPost_hits() %></td>
				
							<td><%=post.getPost_date2() %></td>		
				
						</tr>
				<%} %>
			<%} %>	
		</tbody>
	</table>
	<table style="width: 1038px;">
			<tr>
				<td colspan="6" align="center">
				<hr><br>
				<form action="search_my_post.jsp" method="post">
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
					<a href="javascript:history.back()"><input type="button" value="뒤로가기"></a>
					<a href="my_post_delete.jsp"><input type="button" value="선택 삭제"></a>
				</td>
			</tr>
		</table>
</div>

<jsp:include page="/template/footer.jsp"></jsp:include>