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
<div align="center">
	<h2>"<%=keyword %>" 로 검색한 결과</h2>
	<h3>총 <%=list.size() %> 건의 댓글이 있습니다.</h3> 
	
	<table style="width: 1038px;">
		<thead>
			<tr><td colspan="6"><hr></td></tr>
			<tr>
			
				<th width="70">글번호</th>
						
				<th width="750">댓글 내용</th>
			
				<th width="200">댓글 작성자</th>
						
				<th width="150">작성일</th>
			
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
			
							<td><a href="post.jsp?post_no=<%=rdto.getPost_no() %>"><%=rdto.getReply_content() %></a></td>
			
							<%if(rdto.getReply_id() != null) { %>
			
								<td align="center"><a href="<%=request.getContextPath() %>/member/userinfo.jsp?member_id=<%=rdto.getReply_id()%>"><%=mdto.getMember_nick() %></a></td>
				
							<%}  else {%>
				
								<td align="center"><font color="gray" size="2"><i>탈퇴한 유저</i></font></td>
				
							<%} %>
				
							<td><%=rdto.getReply_date2() %></td>		
				
						</tr>
				<%} %>
			<%} %>	
		</tbody>
	</table>
	<table style="width: 1038px;">
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
					<a href="javascript:history.back()"><input type="button" value="뒤로가기"></a>
					<a href="search_delete.jsp?post_sub=<%=request.getParameter("post_sub")%>&post_title=<%=request.getParameter("post_title")%>"><input type="button" value="선택 삭제"></a>
				</td>
			</tr>
		</table>
</div>

<jsp:include page="/template/footer.jsp"></jsp:include>