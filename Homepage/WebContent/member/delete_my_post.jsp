<%@page import="homepage.beans.dao.ReplyDAO"%>
<%@page import="homepage.beans.dto.MemberDTO"%>
<%@page import="java.util.List"%>
<%@page import="homepage.beans.dto.PostDTO"%>
<%@page import="homepage.beans.dao.PostDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%
	List<PostDTO> list;
	MemberDTO mdto = (MemberDTO) session.getAttribute("userinfo");
	PostDAO pdao = new PostDAO();
	PostDTO pdto = new PostDTO();
	ReplyDAO rdao = new ReplyDAO();
	
	long count;
	String keyword;
	
	 if(request.getParameter("post_sub") != null && request.getParameter("post_title") != null) {
		 
		if(request.getParameter("post_sub").equals("post_nick")){
			// 전체 게시판에서 아이디로 검색 시
			list = pdao.searchNickpost(request.getParameter("post_title"));
			keyword = request.getParameter("post_title");
			
		} else {
			// 전체 게시판에서 제목 및 말머리로 검색 시
			pdto.setPost_sub(request.getParameter("post_sub"));
			pdto.setPost_title(request.getParameter("post_title"));
			list = pdao.searchPost(pdto);
			keyword = request.getParameter("post_title");
		
		}
		 
	 } else {
		 
		 list = pdao.searchNickpost(mdto.getMember_nick());
		 
	 }
	
%>	

<jsp:include page="/template/header.jsp"></jsp:include>

<div align="center">
	<h2><font color="red"><i>삭제할 게시글을 선택해주세요.</i></font></h2>
		
	<br>
	<form action="post_delete.do" method="post">
	<table style="width: 1038px;">
		<thead>
			<tr><td colspan="7"><hr></td></tr>
			<tr>
			
				<th width="35">선택</th>
				
				<th width="70">번호</th>
				
				<th width="100">말머리</th>
				
				<th width="500">제목</th>
				
				<th width="165">작성자</th>
				
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
				<%for(PostDTO post : list) {%>
					<%count = rdao.replyCount(post.getPost_no()); %>
						<tr height="40">
						
							<td align="center"><input type="checkbox" name="post_no" value="<%=post.getPost_no()%>"></td>
							
							<td align="center"><%=post.getPost_no() %></td>
							
							<td align="center"><%=post.getPost_sub() %></td>
							
							<td><a href="<%=request.getContextPath() %>/post/post.jsp?post_no=<%=post.getPost_no() %>"><%=post.getPost_title() %><font size="3" color="gray"><b>    (<%=count %>)</b></font></a></td>
							
							<%if(post.getPost_id() != null) { %>
							
								<td align="center"><a href="<%=request.getContextPath() %>/member/userinfo.jsp?member_id=<%=post.getPost_id()%>"><%=mdto.getMember_nick() %></a></td>
							
							<%}  else {%>
						
								<td align="center"><font color="gray" size="2"><i>탈퇴한 유저</i></font></td>
								
							<%} %>
							
							<td align="center"><%=post.getPost_hits() %></td>
							
							<td align="center"><%=post.getPost_date2() %></td>		
								
						</tr>
				<%} %>
			<%} %>	
			<tr>
				<td>
					<input type="hidden" name="go" value="delete_my_post.jsp">
				</td>
			</tr>
		</tbody>
		<tfoot>
			<tr>
				<td colspan="7" align="center">
					<hr>
					<br>
					<input type="submit" value="삭제">
					<a href="search_my_post.jsp?post_id=<%=mdto.getMember_id()%>"><input type="button" value="목록으로"></a>
				</td>
			</tr>		
		</tfoot>
	</table>
	</form>
	<table style="width: 1038px;">
			<tr>
				<td colspan="6" align="center">
				<br>
				<form action="delete_my_post.jsp" method="post">
					<select name="post_sub">
					
						<option disabled="disabled">선택</option>
						
						<option value="공지">공지</option>
						
						<option value="일반" selected="selected">일반</option>
						
						<option value="정보">정보</option>
						
						<option value="질문">질문</option>
						
						<option value="post_nick">닉네임</option>
						
					</select>
					<input type="text" name="post_title" placeholder="제목">
					<input type="submit" value="검색">
				</form>
			</tr>
		</table>
	<br>
</div>

<jsp:include page="/template/footer.jsp"></jsp:include>