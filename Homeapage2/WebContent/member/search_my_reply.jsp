<%@page import="homepage.beans.dto.MemberDTO"%>
<%@page import="homepage.beans.dao.MemberDAO"%>
<%@page import="homepage.beans.dto.ReplyDTO"%>
<%@page import="java.util.List"%>
<%@page import="homepage.beans.dao.ReplyDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	String keyword = request.getParameter("member_id");
	String column = "REPLY_ID";
	
	ReplyDAO rdao = new ReplyDAO();
	MemberDAO mdao = new MemberDAO();
	MemberDTO mdto = mdao.get(keyword);
	MemberDTO admin = (MemberDTO) session.getAttribute("userinfo");
	boolean login = admin != null;
	
	List<ReplyDTO> list = rdao.replyList(column, keyword);
%>    
    

<jsp:include page="/template/header.jsp"></jsp:include>
<article class="w-100">
	<div class="row-empty"></div>
	<div class="row-empty"></div>
	<div class="row-empty"></div>
	
	<div class="row center">		
		<table class="form-input">
			<thead>
				<tr>
					<th colspan="6">
						<h2 class="title"><i><%=mdto.getMember_nick() %></i> 님의 댓글 리스트</h2>
					</th>
				</tr>
				<tr>
					<th colspan="6">
						<h3>총 <%=list.size() %> 건의 댓글이 있습니다.</h3> 
					</th>
				</tr>
				<tr><td colspan="6"><hr></td></tr>
				<tr>
					<th>글번호</th>							
					<th>댓글 내용</th>
					<th>댓글 작성자</th>
					<th>작성일</th>
				</tr>
			</thead>
			<tbody>
				<%if(list.isEmpty()) { %>
				<tr height="40">
					<th colspan="6">
						<i><b>댓글을 조회할 수 없습니다.</b></i>
					</th>
				</tr>	
				<%} else {%>
					<%for(ReplyDTO rdto : list) {%>
							<tr height="40">
				
								<td align="center"><%=rdto.getPost_no() %></td>
				
								<td><a href="<%=request.getContextPath() %>/post/post.jsp?post_no=<%=rdto.getPost_no() %>"><%=rdto.getReply_content() %></a></td>
				
								<%if(rdto.getReply_id() != null) { %>
				
									<td align="center"><a href="<%=request.getContextPath() %>/member/userinfo.jsp?member_id=<%=rdto.getReply_id()%>"><%=mdto.getMember_nick() %></a></td>
					
								<%}  else {%>
					
									<td align="center"><font color="gray" size="2"><i>탈퇴한 유저</i></font></td>
					
								<%} %>
					
								<td><%=rdto.getReply_date2() %></td>		
								
							</tr>
					<%} %>
				<%} %>
				<tr>
					<td colspan="6" align="right">
						<hr>
						<a href="mypage.jsp"><input type="button" class="btm" value="마이 페이지"></a>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
	<div class="row center">
		<table>
			<tr>
				<td colspan="6" align="center">
					<form action="search_my_reply.jsp" method="post">
						<select class="form-input search-select" name="post_sub">
						<option disabled="disabled">선택</option>
						<option value="공지">공지</option>
						<option value="일반" selected="selected">일반</option>
						<option value="정보">정보</option>		
						<option value="질문">질문</option>			
						<option value="post_id">아이디</option>
					</select>
						<input type="text" class="form-input search-box" name="post_title" placeholder="제목">
						<input type="submit" class="btm" value="검색">
					</form>
					<br>
				</td>
			</tr>
		</table>
	</div>
</article>
<jsp:include page="/template/footer.jsp"></jsp:include>