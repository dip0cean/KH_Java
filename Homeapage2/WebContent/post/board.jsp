<%@page import="homepage.beans.dto.PostFileDTO"%>
<%@page import="homepage.beans.dao.PostFileDAO"%>
<%@page import="homepage.beans.dao.ReplyDAO"%>
<%@page import="homepage.beans.dao.MemberDAO"%>
<%@page import="homepage.beans.dto.MemberDTO"%>
<%@page import="java.util.List"%>
<%@page import="homepage.beans.dto.PostDTO"%>
<%@page import="homepage.beans.dao.PostDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%
	//////////////////////////////////////////
	// 로그인 정보 가지고 오기 및 작성자 정보 가지고 오기       //
	/////////////////////////////////////////
	PostDAO pdao = new PostDAO();
	PostDTO getParameter = new PostDTO();
	MemberDTO mdto = (MemberDTO) session.getAttribute("userinfo");
	MemberDTO member_nick = new MemberDTO();
	MemberDAO mdao = new MemberDAO();
	ReplyDAO rdao = new ReplyDAO();
	List<PostDTO> list;
	
	//////////////////////////////////////////
	// 댓글 개수 조회					       //
	/////////////////////////////////////////
	// 댓글 개수 조회
	long count;
	
	// 로그인 여부
	boolean login = mdto != null;
	
	//////////////////////////////////////////
	// 검색정보 가지고 오기				       //
	/////////////////////////////////////////
	String post_sub = request.getParameter("post_sub");
	String post_title = request.getParameter("post_title");
	
	boolean isSearch = post_sub != null && post_title != null;
	String go = request.getParameter("go");
	String board_title = go;
	String sub_title = board_title;
	
	//////////////////////////////////////////
	// 페이지 계산 코드					       //
	/////////////////////////////////////////
	long pageSize = 20; // 한 페이지에 표시할 데이터 개수
	
	// page 번호를 계산하기 위한 코드
	// - 양수만 페이지 번호로 받음
	String pageStr = request.getParameter("page");
	long pageNum;
	
	try {
		
	pageNum = Long.parseLong(pageStr);
	
	if(pageNum <= 0) {
		
		throw new Exception();
		
	}
		
	} catch (Exception e) {
		
		pageNum = 1;
		
	}
	
	// 시작 글 순서와 종료 글 순서를 계산
	long end = pageNum * pageSize;
	long start = end - (pageSize - 1);
	
	//////////////////////////////////////////
	// 페이지 네비 계산코드				       //
	/////////////////////////////////////////
	long blockSize = 10;
	long startBlock = (pageNum - 1) / blockSize * blockSize + 1;
	long endBlock = startBlock + (blockSize - 1);
	// * 다음 버튼의 경우 계산을 통하여 페이지 개수를 구해야 출력 여부 판단이 가능
	long pageListSize;
	
	//////////////////////////////////////////
	// 게시판 이동 및 검색을 위한 구문			       //
	/////////////////////////////////////////
	if(request.getParameter("go") != null) {
		
		list = pdao.boardPost(go, start, end);
		pageListSize = pdao.getPostCount(go);
		
		if(isSearch && post_sub.equals("member_nick")) {
			go = board_title;
			board_title = sub_title;
			list = pdao.searchNickpost(go, post_title, start, end);
			pageListSize = pdao.getNickPostCount(post_title);
			
		} else if(isSearch && !post_sub.equals("member_nick")){
			
			go = post_sub;
			getParameter.setPost_sub(post_sub);
			getParameter.setPost_title(post_title);
			board_title = post_sub;
			list = pdao.searchPost(getParameter, start, end);
					
			pageListSize = pdao.getPostCount(post_sub, post_title);
		}
		
	} else {
		
		board_title = "전체";
		list = pdao.fullPost(start, end);
		pageListSize = pdao.getPostCount();
		
		if(isSearch) {
			// 말머리와 제목으로 검색했을 때
			board_title = "전체 - " + post_sub;
			getParameter.setPost_sub(request.getParameter("post_sub"));
			getParameter.setPost_title(request.getParameter("post_title"));
			
			list = pdao.searchPost(getParameter, start, end);
			
			pageListSize = pdao.getPostCount(post_sub, post_title);
			
			if(getParameter.getPost_sub().equals("member_nick")) {
				board_title="전체 - 닉네임";
				list = pdao.searchNickpost(request.getParameter("post_title"), start, end);
				pageListSize = pdao.getNickPostCount(post_title);
			}
			
		} 

	}
	
	long pageCount = (pageListSize + pageSize - 1) / pageSize;
	if(endBlock > pageCount) {
		endBlock = pageCount;
	}
	
	PostFileDAO pfdao = new PostFileDAO();
	
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
					<th colspan="6" class="title"><i><%=board_title %></i></th>
				</tr>
				<tr>
					<td><div class="row-empty"></div></td>
				</tr>
				<tr>
					<th colspan="6" class="subtitle">
						<a href="board.jsp?page=<%=pageNum%>">전체</a>
						<a href="board.jsp?go=공지&page=<%=pageNum%>">공지</a>
						<a href="board.jsp?go=일반&page=<%=pageNum%>">일반</a>
						<a href="board.jsp?go=정보&page=<%=pageNum%>">정보</a>
						<a href="board.jsp?go=질문&page=<%=pageNum%>">질문</a>
					</th>
				</tr>
				<tr>
					<td><div class="row-empty"></div></td>
				</tr>
				<tr>
					<td colspan="6">
						<hr>
					</td>
				</tr>
				<tr>
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
					<%for(PostDTO pdto : list) {%>
							<%count = rdao.replyCount(pdto.getPost_no()); %>
							<%member_nick = mdao.get(pdto.getPost_id()); %>
							<%boolean post_file = !pfdao.getList(pdto.getPost_no()).isEmpty(); %>
							<tr height="40">
				
								<td align="center"><%=pdto.getPost_no() %></td>
				
								<td align="center"><%=pdto.getPost_sub() %></td>
				
								<td>
									<a href="post.jsp?post_no=<%=pdto.getPost_no() %>">
									<%if(pdto.getDepth() != 0) { %>
										<%for(int i = 1 ; i <= pdto.getDepth(); i++ ) { %>
											&emsp;
										<%} %>
										<img alt="답글" src="<%=request.getContextPath()%>/image/reply.png" width="15" height="15">
									<%} %>
										<%=pdto.getPost_title() %><font size="3" color="gray"><b>    (<%=count %>)</b></font>
										<%if(post_file) { %>
										<img alt="파일" src="<%=request.getContextPath()%>/image/download.png" width="15" height="15">
										<%} %>
									</a>
								</td>
	<%-- 							<td>super_no<%=pdto.getSuper_no() %></td> --%>
	<%-- 							<td>group_no<%=pdto.getGroup_no() %></td> --%>
	<%-- 							<td>depth<%=pdto.getDepth() %> --%>
								<%if(pdto.getPost_id() != null) { %>
				
									<td align="center"><a href="<%=request.getContextPath() %>/member/userinfo.jsp?member_id=<%=pdto.getPost_id()%>&go=<%=request.getContextPath()%>/post/board.jsp"><%=member_nick.getMember_nick() %></a></td>
				
								<%}  else {%>
				
									<td align="center"><font color="gray" size="2"><i>탈퇴한 유저</i></font></td>
					
								<%} %>
					
								<td align="center"><%=pdto.getPost_hits() %></td>
					
								<td align="center"><%=pdto.getPost_date2() %></td>			
								
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
						<a href="create.jsp"><input class="btm" type="button" value="글쓰기"></a>
						
						<%if(login && mdto.getAccess_auth().equals("운영자")) {%>
						
						<a href="<%=request.getContextPath() %>/admin/post_delete.jsp"><input class="btm" type="button" value="선택 삭제"></a>
						
						<%} %>
					</td>
				</tr>
				<tr>
					<td colspan="6" align="center">
						<div class="page-number-highlight">
							<%if(startBlock > 1) { %>
								<%if(isSearch) { %>
									<%if(go == null) { %>
										<a href="board.jsp?page=<%=startBlock - 1%>&post_sub=<%=post_sub%>&post_title=<%=post_title%>">&lt;</a>
									<%} else { %>
										<a href="board.jsp?page=<%=startBlock - 1%>&post_sub=<%=post_sub%>&post_title=<%=post_title%>&go=<%=go%>">&lt;</a>	
									<%} %>
								<%} else {%>
									<%if(go == null) { %>
										<a href="board.jsp?page=<%=startBlock - 1%>">&lt;</a>
									<%} else {%>
										<a href="board.jsp?page=<%=startBlock - 1%>go=<%=go%>">&lt;</a>
									<%} %>
								<%} %>
							<%} %>	
									<%for(long i = startBlock; i <= endBlock; i ++) { %>
										<%
											String prop;
											if(i == pageNum) {
												prop = "on";
											} else {
												prop = "";
											}
										
										%>
											<%if(isSearch) {%>
												<%if(go == null) { %>
													<a href="<%=request.getContextPath()%>/post/board.jsp?page=<%=i%>&post_sub=<%=post_sub%>&post_title=<%=post_title%>" class="<%=prop %>"><%=i %></a>
												<%} else { %>
													<a href="<%=request.getContextPath()%>/post/board.jsp?page=<%=i%>&post_sub=<%=post_sub%>&post_title=<%=post_title%>&go=<%=go%>" class="<%=prop %>"><%=i %></a>
												<%} %>
											<%} else { %>
												<%if(go == null) { %>
													<a href="<%=request.getContextPath()%>/post/board.jsp?page=<%=i%>" class="<%=prop %>"><%=i %></a>
												<%} else { %>
													<a href="<%=request.getContextPath()%>/post/board.jsp?page=<%=i%>&go=<%=go%>" class="<%=prop %>"><%=i %></a>
												<%} %>
											<%} %>
										<%} %>
				
						<%if(pageCount > endBlock) { %>		
							<%if(isSearch) { %>
								<%if(go == null) { %>
									<a href="board.jsp?page=<%=endBlock + 1%>&post_sub=<%=post_sub%>&post_title=<%=post_title%>">&gt;</a>
								<%} else { %>
									<a href="board.jsp?page=<%=endBlock + 1%>&post_sub=<%=post_sub%>&post_title=<%=post_title%>&go=<%=go%>">&gt;</a>
								<%} %>
							<%} else {%>
								<%if(go == null) { %>
									<a href="board.jsp?page=<%=endBlock + 1%>">&gt;</a>
								<%} else { %>
									<a href="board.jsp?page=<%=endBlock + 1%>&go=<%=go%>">&gt;</a>
								<%} %>
							<%} %>
						<%} %>	
						</div>
					</td>
				</tr>
			</tfoot>
		</table>
	</div>
	<div class="row-empty"></div>
	<div class="row center">	
		<table>
			<tr>
				<td>
					<form action="board.jsp" method="post">
				
						<select class="form-input search-select" name="post_sub">
					
							<option disabled="disabled">선택</option>
				
							<option value="공지">공지</option>
					
							<option value="일반" selected="selected">일반</option>
					
							<option value="정보">정보</option>
					
							<option value="질문">질문</option>
				
							<option value="member_nick">닉네임</option>
					
						</select>
						<input type="text" class="form-input search-box" name="post_title" placeholder="검색어">
						
						<%if(request.getParameter("go") != null) { %>
							
							<input type="hidden" name="go" value="<%=go %>">	
						
						<%} %>
						
						<input class="btm" type="submit" value="검색">
					
					</form>
				</td>
			</tr>
		</table>
	</div>
</article>	

<jsp:include page="/template/footer.jsp"></jsp:include>