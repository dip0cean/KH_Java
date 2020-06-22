<%@page import="homepage.beans.dao.ReplyDAO"%>
<%@page import="homepage.beans.dao.MemberDAO"%>
<%@page import="homepage.beans.dto.MemberDTO"%>
<%@page import="java.util.List"%>
<%@page import="homepage.beans.dto.PostDTO"%>
<%@page import="homepage.beans.dao.PostDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%
	PostDAO pdao = new PostDAO();
	PostDTO getParameter = new PostDTO();
	MemberDTO mdto = (MemberDTO) session.getAttribute("userinfo");
	MemberDTO member_nick = new MemberDTO();
	MemberDAO mdao = new MemberDAO();
	ReplyDAO rdao = new ReplyDAO();
	List<PostDTO> list;
	
	long count;
	boolean login = mdto != null;
	boolean parameter = request.getParameter("post_sub") != null && request.getParameter("post_title") != null;
	String post_sub = request.getParameter("post_sub");
	String go = request.getParameter("go");
	String board_title = go;
	String sub_title = board_title;
	
	// 게시판 이동을 위한 구문
	if(request.getParameter("go") != null) {
		
		list = pdao.boardPost(go);
		
		if(parameter && post_sub.equals("member_nick")) {
			go = board_title;
			board_title = sub_title;
			list = pdao.searchNickpost(go, request.getParameter("post_title"));
			
		} else if(parameter && !request.getParameter("post_sub").equals("member_nick")){
			
			go = post_sub;
			getParameter.setPost_sub(post_sub);
			getParameter.setPost_title(request.getParameter("post_title"));
			board_title = post_sub;
			list = pdao.searchPost(getParameter);
					
		}
		
	} else {
		
		board_title = "전체";
		list = pdao.fullPost();
		
		if(parameter) {
			// 말머리와 제목으로 검색했을 때
			board_title = "전체 - " + post_sub;
			getParameter.setPost_sub(request.getParameter("post_sub"));
			getParameter.setPost_title(request.getParameter("post_title"));
			
			list = pdao.searchPost(getParameter);
			
			if(getParameter.getPost_sub().equals("member_nick")) {
				board_title="전체 - 닉네임";
				list = pdao.searchNickpost(request.getParameter("post_title"));
			}
			
		} 

	}
	
%>	

<jsp:include page="/template/header.jsp"></jsp:include>

<div align="center">
	<h2><%=board_title %></h2>
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
						<%count = rdao.replyCount(pdto.getPost_no()); %>
						<%member_nick = mdao.get(pdto.getPost_id()); %>
						<tr height="40">
			
							<td align="center"><%=pdto.getPost_no() %></td>
			
							<td align="center"><%=pdto.getPost_sub() %></td>
			
							<td>
								<a href="post.jsp?post_no=<%=pdto.getPost_no() %>">
								<%if(pdto.getDepth() != 0) { %>
									<%for(int i = 1 ; i <= pdto.getDepth(); i++ ) { %>
										&emsp;
									<%} %>
									┗
								<%} %>
									<%=pdto.getPost_title() %><font size="3" color="gray"><b>    (<%=count %>)</b></font>
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
				
							<td><%=pdto.getPost_date2() %></td>			
				
						</tr>
				<%} %>
			<%} %>	
		</tbody>
	</table>
	<table style="width: 1038px;">
			<tr>
				<td colspan="6" align="center">
				<hr><br>
			
				<form action="board.jsp" method="post">

					<select name="post_sub">
			
						<option disabled="disabled">선택</option>

						<option value="공지">공지</option>
			
						<option value="일반" selected="selected">일반</option>
			
						<option value="정보">정보</option>
			
						<option value="질문">질문</option>

						<option value="member_nick">닉네임</option>
			
					</select>
					<input type="text" name="post_title" placeholder="검색어">
				<%if(request.getParameter("go") != null) { %>
					<input type="hidden" name="go" value="<%=go %>">	
				<%} %>
					<input type="submit" value="검색">
				</form>
				<br>
					<a href="create.jsp"><input type="button" value="글쓰기"></a>
					<%if(login && mdto.getAccess_auth().equals("운영자")) {%>
					<a href="<%=request.getContextPath() %>/admin/post_delete.jsp"><input type="button" value="선택 삭제"></a>
					<%} %>
				</td>
			</tr>
		</table>
	<br>
</div>

<jsp:include page="/template/footer.jsp"></jsp:include>