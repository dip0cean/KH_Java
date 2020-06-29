<%@page import="homepage.beans.dao.PostFileDAO"%>
<%@page import="homepage.beans.dao.ReplyDAO"%>
<%@page import="homepage.beans.dto.MemberDTO"%>
<%@page import="homepage.beans.dao.MemberDAO"%>
<%@page import="java.util.List"%>
<%@page import="homepage.beans.dto.PostDTO"%>
<%@page import="homepage.beans.dao.PostDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%	
	String member_id = request.getParameter("post_id");
	String post_sub = request.getParameter("post_sub");
	String post_title = request.getParameter("post_title");
	
	// 페이지 확인하기
	String pageStr = request.getParameter("page");
	long pageSize = 20;
	long pageNum;
	
	try{
		
		pageNum = Long.parseLong(pageStr);
		
		if(pageNum <= 0) {
			
			throw new Exception();
		}
		
	} catch(Exception e) {
		
		pageNum = 1;
		
	}
	
	long end = pageNum * pageSize;
	long start = end - (pageSize - 1);
	
	long blockSize = 10;
	long startBlock = (pageNum - 1) / blockSize * blockSize + 1;
	long endBlock = startBlock + (blockSize - 1);
	
	// 정보 준비
	PostDAO pdao = new PostDAO();
	PostDTO pdto = new PostDTO();
	ReplyDAO rdao = new ReplyDAO();
	PostFileDAO pfdao = new PostFileDAO();
	MemberDTO mdto = (MemberDTO) session.getAttribute("userinfo");
	List<PostDTO> list = pdao.userPost(member_id, start, end);
	boolean login = mdto != null;
	
	// 댓글 개수 가지고 오기
	long count;
	// 회원 정보 가지고 오기
	String keyword = member_id;
	String url = "?";
	boolean isSearch = post_sub != null && post_title != null && member_id != null;
	
	// 회원의 게시물 개수 조회
	long pageListSize = pdao.getNickPostCount(mdto.getMember_nick());

	if (isSearch) {
		
 		// 게시글 조회 후 제목 및 말머리로 검색 시
 		pdto.setPost_id(member_id);
		pdto.setPost_sub(post_sub);
		pdto.setPost_title(post_title);
		list = pdao.searchMyPost(pdto, start, end);
		pageListSize = pdao.getPostCount(post_sub, post_title);
		keyword = post_title;
		url = "?post_sub=" + post_sub + "&post_title=" + post_title;
	
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
		<table class="form-input">
			<thead>
				<tr>
					<th colspan="6">
						<h3 class="title"><i><%=mdto.getMember_nick() %></i> 님의 게시글 목록</h3>
					</th>
				</tr>
				<tr>
					<th colspan="6">
						<%if(isSearch) { %>
							<h3>"<%=keyword %>" 로 검색한 결과</h3>
							<h4>총 <%=list.size() %> 건의 게시글이 있습니다.</h4> 
						<%} %>
					</th>
				</tr>
				<tr>
					<td colspan="6"><hr></td>
				</tr>
				<tr>
				
					<th width="70">번호</th>
				
					<th width="100">말머리</th>
				
					<th width="550">제목</th>
				
					<th width="200">작성자</th>
				
					<th width="100">조회수</th>
				
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
							<%
								count = rdao.replyCount(post.getPost_no());
								boolean post_file = !pfdao.getList(post.getPost_no()).isEmpty();
							%>
							<tr height="40">
				
								<td align="center"><%=post.getPost_no() %></td>
				
								<td align="center"><%=post.getPost_sub() %></td>
				
								<td>
									<%if(post.getDepth() != 0) { %>
										<%for(int i = 1; i <= post.getDepth(); i++ ) { %>
											&emsp;
										<%} %>
										<img alt="답글" src="<%=request.getContextPath()%>/image/reply.png" width="15" height="15">
									<%} %>
									<a href="<%=request.getContextPath() %>/post/post.jsp?post_no=<%=post.getPost_no() %>">
										<%=post.getPost_title() %>
										<%if(count > 0) { %>
											<font size="3" color="gray"><b>    (<%=count %>)</b></font>
										<%} %>
										<%if(post_file) {%>
											<img alt="파일" src="<%=request.getContextPath()%>/image/download.png" width="15" height="15">
										<%} %>
									</a>
								</td>
				
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
					<td colspan="6">
						<hr>
					</td>
				</tr>
				<tr>
					<td colspan="6" align="right">
						<a href="<%=request.getContextPath() %>/post/create.jsp"><input type="button" class="btm" value="글쓰기"></a>
						<a href="delete_my_post.jsp<%=url%>"><input type="button" class="btm" value="선택 삭제"></a>
						<a href="mypage.jsp"><input type="button" class="btm" value="마이 페이지"></a>
					</td>
				</tr>
				<tr>
					<td colspan="6" align="center">
						<div class="page-number-highlight">
							<%if(startBlock > 1) { %>
								<%if(isSearch) { %>
									<a href="search_my_post.jsp?post_id=<%=member_id%>&post_sub=<%=post_sub%>&post_title=<%=post_title%>&page=<%=startBlock - 1%>">&lt;</a>
								<%} else { %>
									<a href="search_my_post.jsp?post_id=<%=member_id%>&page=<%=startBlock - 1%>">&lt;</a>
								<%} %>
							<%} %>
								<%for(long i = startBlock; i <= endBlock; i++) { %>
									<%
										String prop;
										if(i == pageNum) {
											prop = "on";
										} else {
											prop = "";
										}
									%>
									<%if(isSearch) { %>
										<a href="search_my_post.jsp?post_id=<%=member_id %>&post_sub=<%=post_sub %>&post_title=<%=post_title %>&page=<%=i%>" class="<%=prop%>"><%=i %></a>
									<%} else { %>
										<a href="search_my_post.jsp?post_id=<%=member_id %>&page=<%=i%>" class="<%=prop%>"><%=i %></a>
									<%} %>
								<%} %>
							<%if(pageCount > endBlock) { %>
								<%if(isSearch) { %>
									<a href="search_my_post.jsp?post_id=<%=member_id%>&post_sub=<%=post_sub%>&post_title=<%=post_title%>&page=<%=endBlock + 1 %>">&gt;</a>
								<%} else { %>
									<a href="search_my_post.jsp?post_id=<%=member_id%>&page=<%=endBlock + 1%>">&gt;</a>
								<%} %>
							<%} %>	
						</div>
					</td>
				</tr>
			</tfoot>
		</table>
	</div>
	<div class="row">	
		<table>
			<tr>
				<td colspan="6" align="center">
				<br>
				<form action="search_my_post.jsp" method="post">
					<input type="hidden" name="post_id" value="<%=member_id %>">	
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
				<br>
			</tr>
		</table>
	</div>
	
	<div class="row-empty"></div>
	<div class="row-empty"></div>
	<div class="row-empty"></div>		
</article>

<jsp:include page="/template/footer.jsp"></jsp:include>