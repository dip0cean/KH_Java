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
			list = pdao.searchMyPost(pdto, start, end);
			keyword = post_title;
			
			pageListSize = pdao.getPostCount(post_sub, post_title);
		
	}

	 long pageCount = (pageListSize + pageSize - 1) / pageSize;
	 if(endBlock > pageCount) {
		 endBlock = pageCount;
	 }
	
%>	

<jsp:include page="/template/header.jsp"></jsp:include>

<article class="w-100">
	<div class="row-empty"></div>
	<div class="row-empty"></div>
	<div class="row-empty"></div>
	
	<div class="row">
		<form action="post_delete.do" method="post">
		<table class="form-input">
			<thead>
				<tr>
					<th colspan="7">
						<h2><font color="orange"><i>삭제할 게시글을 선택해주세요.</i></font></h2>
					</th>
				</tr>
				<tr>
					<td colspan="7"><hr></td>
				</tr>
				<tr>
				
					<th>선택</th>
					
					<th>번호</th>
					
					<th>말머리</th>
					
					<th>제목</th>
					
					<th>작성자</th>
					
					<th>조회수</th>
					
					<th>작성일</th>
					
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
						<input type="submit" class="btm" value="삭제">
						<a href="search_my_post.jsp?post_id=<%=mdto.getMember_id()%>"><input type="button" class="btm" value="목록으로"></a>
					</td>
				</tr>
				<tr>
					<td colspan="7" align="center">
					<div class="page-number-highlight">	
						<%if(startBlock > 1) { %>
							<%if(isSearch) { %>
								<a href="delete_my_post.jsp?post_sub=<%=post_sub%>&post_title=<%=post_title%>&page=<%=startBlock - 1%>">&lt;</a>
							<%} else {%>
								<a href="delete_my_post.jsp?page=<%=startBlock - 1 %>">&lt;</a>
							<%} %>
						<%} %>	
						
						<%for(long i = startBlock; i <= endBlock; i++) { %>
							<%
								String prop;
								if(pageNum == i) {
									prop = "class='on'";
								} else {
									prop = "";
								}
							%>
								<%if(isSearch) { %>
									<a href="delete_my_post.jsp?post_sub=<%=post_sub%>&post_title=<%=post_title%>&page=<%=i%>" <%=prop %>><%=i %></a>
								<%} else { %>
									<a href="delete_my_post.jsp?page=<%=i%>" <%=prop %>><%=i %></a>
								<%} %>
						<%} %>	
							
						<%if(pageCount > endBlock) {%>	
							<%if(isSearch) { %>
								<a href="delete_my_post.jsp?post_sub=<%=post_sub%>&post_title=<%=post_title%>&page=<%=endBlock + 1%>">&gt;</a>
							<%} else {%>
								<a href="delete_my_post.jsp?page=<%=endBlock + 1 %>">&gt;</a>
							<%} %>	
						<%} %>
					</div>	
					</td>
				</tr>		
			</tfoot>
		</table>
		</form>
		<div class="row-empty"></div>
		<div class="row center">
			<table>
					<tr>
						<td>
						<br>
						<form action="delete_my_post.jsp" method="get">
							<input type="hidden" name="post_id" value="<%=mdto.getMember_id() %>">
							<select class="form-input search-select" name="post_sub">
							
								<option disabled="disabled">선택</option>
								
								<option value="공지">공지</option>
								
								<option value="일반" selected="selected">일반</option>
								
								<option value="정보">정보</option>
								
								<option value="질문">질문</option>
								
							</select>
							<input type="text" class="form-input search-box" name="post_title" placeholder="제목">
							<input type="submit" class="btm" value="검색">
						</form>
					</tr>
				</table>
			</div>
		<br>
	</div>
	
	<div class="row-empty"></div>
	<div class="row-empty"></div>
	<div class="row-empty"></div>		
</article>

<jsp:include page="/template/footer.jsp"></jsp:include>