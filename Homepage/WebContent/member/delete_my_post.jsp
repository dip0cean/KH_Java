<%@page import="homepage.beans.dao.ReplyDAO"%>
<%@page import="homepage.beans.dto.MemberDTO"%>
<%@page import="java.util.List"%>
<%@page import="homepage.beans.dto.PostDTO"%>
<%@page import="homepage.beans.dao.PostDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%
	// 로그인 정보 및 회원 정보 
	List<PostDTO> list;
	MemberDTO mdto = (MemberDTO) session.getAttribute("userinfo");
	PostDAO pdao = new PostDAO();
	PostDTO pdto = new PostDTO();
	ReplyDAO rdao = new ReplyDAO();
	

	String post_sub = request.getParameter("post_sub");
	String post_title = request.getParameter("post_title");
	boolean isSearch = post_sub != null && post_title != null;
	// 댓글 갯수
	long count;
	String keyword;
	
	// 페이징 준비
	long pageSize = 20;
	String pageStr = request.getParameter("page");
	long pageNum;
	try {
		
		pageNum = Long.parseLong(pageStr);
		
		if(pageNum <= 0) {
			
			throw new Exception();
			
		}
		
	} catch(Exception e) {
		
		pageNum = 1;
		
	}
	
	long end = pageNum * pageSize;
	long start = end - (pageSize - 1);
	
	long pageListSize;
	long blockSize = 10; // 페이지 개수
	long startBlock = (pageNum - 1) / blockSize * blockSize + 1;
	long endBlock = startBlock + (blockSize - 1);
	
	 list = pdao.searchNickpost(mdto.getMember_nick(), start, end);
	 
	 pageListSize = pdao.getNickPostCount(mdto.getMember_nick());
	
	 if(isSearch) {
		
			// 전체 게시판에서 제목 및 말머리로 검색 시
			pdto.setPost_id(mdto.getMember_id());
			pdto.setPost_sub(post_sub);
			pdto.setPost_title(post_title);
			list = pdao.searchPost(pdto, start, end);
			keyword = post_title;
			
			pageListSize = pdao.getPostCount(post_sub, post_title);
		
	}

	 long pageCount = (pageListSize + pageSize - 1) / pageSize;
	 if(endBlock > pageCount) {
		 endBlock = pageCount;
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
		</tbody>
		<tfoot>
			<tr>
				<td colspan="7">
					<hr>
				</td>
			</tr>
			<tr>
				<td colspan="7" align="right">
					<input type="hidden" name="go" value="delete_my_post.jsp">
					<input type="submit" value="삭제">
					<a href="search_my_post.jsp?post_id=<%=mdto.getMember_id()%>"><input type="button" value="목록으로"></a>
				</td>
			</tr>
			<tr>
				<td colspan="7" align="center">
					
					<%if(startBlock > 1) { %>
						<%if(isSearch) { %>
							<a href="delete_my_post.jsp?post_sub=<%=post_sub%>&post_title=<%=post_title%>&page=<%=startBlock - 1%>">[이전]</a>
						<%} else {%>
							<a href="delete_my_post.jsp?page=<%=startBlock - 1 %>">[이전]</a>
						<%} %>
					<%} %>	
					
					<%for(long i = startBlock; i <= endBlock; i++) { %>
						<%if(isSearch) { %>
							<a href="delete_my_post.jsp?post_sub=<%=post_sub%>&post_title=<%=post_title%>&page=<%=i%>"><%=i %></a>
						<%} else { %>
							<a href="delete_my_post.jsp?page=<%=i%>"><%=i %></a>
						<%} %>
					<%} %>	
						
					<%if(pageCount > endBlock) {%>	
						<%if(isSearch) { %>
							<a href="delete_my_post.jsp?post_sub=<%=post_sub%>&post_title=<%=post_title%>&page=<%=endBlock + 1%>">[다음]</a>
						<%} else {%>
							<a href="delete_my_post.jsp?page=<%=endBlock + 1 %>">[다음]</a>
						<%} %>	
					<%} %>
				</td>
			</tr>		
		</tfoot>
	</table>
	</form>
	<table style="width: 1038px;">
			<tr>
				<td colspan="6" align="center">
				<br>
				<form action="delete_my_post.jsp" method="get">
					<select name="post_sub">
					
						<option disabled="disabled">선택</option>
						
						<option value="공지">공지</option>
						
						<option value="일반" selected="selected">일반</option>
						
						<option value="정보">정보</option>
						
						<option value="질문">질문</option>
						
					</select>
					<input type="text" name="post_title" placeholder="제목">
					<input type="submit" value="검색">
				</form>
			</tr>
		</table>
	<br>
</div>

<jsp:include page="/template/footer.jsp"></jsp:include>