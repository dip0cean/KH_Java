<%@page import="homepage.beans.dao.MemberDAO"%>
<%@page import="homepage.beans.dto.MemberDTO"%>
<%@page import="java.util.List"%>
<%@page import="homepage.beans.dto.PostDTO"%>
<%@page import="homepage.beans.dao.PostDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%
	PostDAO pdao = new PostDAO();
	List<PostDTO> list;
	String go = request.getParameter("go");
	if(request.getParameter("go") != null) {
		list = pdao.boardPost(go);
	} else {
		go = "전체";
		list = pdao.fullPost();
	}
	MemberDTO mdto = (MemberDTO) session.getAttribute("userinfo");
	MemberDAO mdao = new MemberDAO();
	
	mdto = mdao.get(mdto.getMember_id());

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
				<td colspan="7" align="center">
					<hr>
					<br>
					<input type="submit" value="삭제">
					<a href="javascript:history.back()"><input type="button" value="뒤로 가기"></a>
				</td>
			</tr>		
		</tfoot>
	</table>
	</form>
	<table style="width: 1038px;">
			<tr>
				<td colspan="6" align="center">
				<br>
				<form action="search_delete.jsp" method="post">
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
			</tr>
		</table>
	<br>
</div>

<jsp:include page="/template/footer.jsp"></jsp:include>