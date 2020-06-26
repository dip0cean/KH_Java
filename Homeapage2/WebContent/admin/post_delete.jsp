<%@page import="homepage.beans.dao.MemberDAO"%>
<%@page import="homepage.beans.dto.MemberDTO"%>
<%@page import="java.util.List"%>
<%@page import="homepage.beans.dto.PostDTO"%>
<%@page import="homepage.beans.dao.PostDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%
	PostDAO pdao = new PostDAO();
	PostDTO setPost = new PostDTO();
	MemberDTO mdto = (MemberDTO) session.getAttribute("userinfo");
	MemberDAO mdao = new MemberDAO();
	
	List<PostDTO> list;
	
	String post_sub = request.getParameter("post_sub");
	String post_title = request.getParameter("post_title");
	String pageStr = request.getParameter("page");
	String go = request.getParameter("go");
	String board_title = go;
	String sub_title = board_title;
	
	mdto = mdao.get(mdto.getMember_id());
	boolean isSearch = post_sub != null && post_title != null;
	
	long count;
	String keyword;
	
	long pageSize = 20;
	long pageNum;
	
	try {
		
		pageNum = Long.parseLong(pageStr);
		
		if(pageNum <= 0) {
			
			throw new Exception();
			
		}
		
	} catch (Exception e) {
		
		pageNum = 1;
		
	}
	
	long end = pageNum * pageSize;
	long start = end - (pageSize - 1);
	
	long blockSize = 10;
	long startBlock = (pageNum - 1) / blockSize * blockSize + 1;
	long endBlock = startBlock + (blockSize - 1);
	long pageListSize;
	
	if(go != null) {
		list = pdao.boardPost(go, start, end);
		pageListSize = pdao.getPostCount(post_sub);
		
		if(isSearch && post_sub.equals("member_nick")){
			// 전체 게시판에서 아이디로 검색 시
			go = board_title;
			board_title = sub_title;
			list = pdao.searchNickpost(go, post_title, start, end);
			pageListSize = pdao.getNickPostCount(post_title);

			
		} else if(isSearch && !post_sub.equals("member_nick")) {
			// 전체 게시판에서 제목 및 말머리로 검색 시
			go = post_sub;
			setPost.setPost_sub(post_sub);
			setPost.setPost_title(post_title);
			list = pdao.searchPost(setPost, start, end);
			pageListSize = pdao.getPostCount(post_sub, post_title);

		
		}
	} else {
		board_title = "전체";
		list = pdao.fullPost(start, end);
		pageListSize = pdao.getPostCount();
		
		if(isSearch) {
			board_title = "전체 - " + post_sub;
			setPost.setPost_sub(post_sub);
			setPost.setPost_title(post_title);
			
			list = pdao.searchPost(setPost, start, end);
			pageListSize = pdao.getPostCount(post_sub, post_title);
			
			if(post_sub.equals("member_nick")) {
				board_title = "전체 - 닉네임";
				list = pdao.searchNickpost(post_title, start, end);
				pageListSize = pdao.getNickPostCount(post_title);
			}
		}
	}
	
	long pageCount = (pageListSize + pageSize - 1) / pageSize;
	if(endBlock > pageCount) {
		endBlock = pageCount;
	}

%>	

<jsp:include page="/template/header.jsp"></jsp:include>

<div align="center">
	<h2><%=board_title %></h2>
	<table>
		<thead>
			<tr>
			
				<th><a href="post_delete.jsp">전체</a></th>
			
				<th><a href="post_delete.jsp?go=공지">공지</a></th>
			
				<th><a href="post_delete.jsp?go=일반">일반</a></th>
			
				<th><a href="post_delete.jsp?go=정보">정보</a></th>
			
				<th><a href="post_delete.jsp?go=질문">질문</a></th>
			
			</tr>
		</thead>
	</table>
	<h2><font color="red"><i>삭제할 게시글을 선택해주세요.</i></font></h2>
	<br>
	<form action="post_delete.do" method="post">
	<table style="width: 1038px;">
		<thead>
			<tr><td colspan="7"><hr></td></tr>
			<tr>
			
				<th width="50">선택</th>
			
				<th width="70">번호</th>
			
				<th width="95">말머리</th>
			
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
				<%for(PostDTO pdto : list) {%>
						<tr height="40">
							<td align="center"><input type="checkbox" name="post_no" value="<%=pdto.getPost_no()%>"></td>
							
							<td align="center"><%=pdto.getPost_no() %></td>
							
							<td align="center"><%=pdto.getPost_sub() %></td>
							
							<td><a href="<%=request.getContextPath() %>/post/post.jsp?post_no=<%=pdto.getPost_no() %>"><%=pdto.getPost_title() %></a></td>
							
							<%if(pdto.getPost_id() != null) { %>
							
								<td align="center"><a href="<%=request.getContextPath() %>/member/userinfo.jsp?member_id=<%=pdto.getPost_id()%>"><%=pdto.getPost_id() %></a></td>
							
							<%}  else {%>
								
								<td align="center"><font color="gray" size="2"><i>탈퇴한 유저</i></font></td>
							
							<%} %>
							
							<td align="center"><%=pdto.getPost_hits() %></td>
							
							<td align="center"><%=pdto.getPost_date2() %></td>			
						
						</tr>
				<%} %>
			<%} %>
			<tr>
				<td>
					<input type="hidden" name="go" value="post_delete.jsp">
				</td>
			</tr>	
		</tbody>
		<tfoot>
			<tr>
				<td colspan="7" align="right">
					<hr>
					<br>
					<input type="submit" value="삭제">
					<a href="<%=request.getContextPath()%>/post/board.jsp"><input type="button" value="목록으로"></a>
				</td>
			</tr>		
			<tr>
				<td colspan="7" align="center">
				<%if(startBlock > 1) { %>
					<%if(isSearch) { %>
						<%if(go == null) { %>
							<a href="post_delete.jsp?page=<%=startBlock - 1%>&post_sub=<%=post_sub%>&post_title=<%=post_title%>">[이전]</a>
						<%} else { %>
							<a href="post_delete.jsp?page=<%=startBlock - 1%>&post_sub=<%=post_sub%>&post_title=<%=post_title%>&go=<%=go%>">[이전]</a>	
						<%} %>
					<%} else {%>
						<%if(go == null) { %>
							<a href="post_delete.jsp?page=<%=startBlock - 1%>">[이전]</a>
						<%} else {%>
							<a href="post_delete.jsp?page=<%=startBlock - 1%>go=<%=go%>">[이전]</a>
						<%} %>
					<%} %>
				<%} %>	
						<%for(long i = startBlock; i <= endBlock; i ++) { %>
							<%if(isSearch) {%>
								<%if(go == null) { %>
									<a href="post_delete.jsp?page=<%=i%>&post_sub=<%=post_sub%>&post_title=<%=post_title%>"><%=i %></a>
								<%} else { %>
									<a href="post_delete.jsp?page=<%=i%>&post_sub=<%=post_sub%>&post_title=<%=post_title%>&go=<%=go%>"><%=i %></a>
								<%} %>
							<%} else { %>
								<%if(go == null) { %>
									<a href="post_delete.jsp?page=<%=i%>"><%=i %></a>
								<%} else { %>
									<a href="post_delete.jsp?page=<%=i%>&go=<%=go%>"><%=i %></a>
								<%} %>
							<%} %>
						<%} %>
				
				<%if(pageCount > endBlock) { %>		
					<%if(isSearch) { %>
						<%if(go == null) { %>
							<a href="post_delete.jsp?page=<%=endBlock + 1%>&post_sub=<%=post_sub%>&post_title=<%=post_title%>">[다음]</a>
						<%} else { %>
							<a href="post_delete.jsp?page=<%=endBlock + 1%>&post_sub=<%=post_sub%>&post_title=<%=post_title%>&go=<%=go%>">[다음]</a>
						<%} %>
					<%} else {%>
						<%if(go == null) { %>
							<a href="post_delete.jsp?page=<%=endBlock + 1%>">[다음]</a>
						<%} else { %>
							<a href="post_delete.jsp?page=<%=endBlock + 1%>&go=<%=go%>">[다음]</a>
						<%} %>
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
				<form action="post_delete.jsp" method="get">
					<select name="post_sub">
						
						<option disabled="disabled">선택</option>
						
						<option value="공지">공지</option>
						
						<option value="일반" selected="selected">일반</option>
						
						<option value="정보">정보</option>
						
						<option value="질문">질문</option>
						
						<option value="member_nick">닉네임</option>
					
					</select>
					<input type="text" name="post_title" placeholder="제목">
					<input type="submit" value="검색">
				</form>
			</tr>
		</table>
	<br>
</div>

<jsp:include page="/template/footer.jsp"></jsp:include>