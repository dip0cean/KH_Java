<%@page import="homepage.beans.dao.MemberDAO"%>
<%@page import="homepage.beans.dto.ReplyDTO"%>
<%@page import="java.util.List"%>
<%@page import="homepage.beans.dao.ReplyDAO"%>
<%@page import="java.util.HashSet"%>
<%@page import="java.util.Set"%>
<%@page import="homepage.beans.dao.PostDAO"%>
<%@page import="homepage.beans.dto.MemberDTO"%>
<%@page import="homepage.beans.dto.PostDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	PostDAO pdao = new PostDAO();
	long post_no = Integer.parseInt(request.getParameter("post_no"));
	MemberDAO mdao = new MemberDAO();
	MemberDTO mdto = (MemberDTO) session.getAttribute("userinfo");
	
	// 조회수 검사 및 증가
	Set<Long> memory = (Set<Long>) session.getAttribute("memory");
	
	if(memory == null) {
		memory = new HashSet<>();
	}
	
	boolean isFirst = memory.add(post_no);
	
	session.setAttribute("memory", memory);
	
	if(isFirst) {
		
		pdao.getHits(post_no, mdto.getMember_id()); 
		
	}
	
	// 작성자와 현재 회원 비교 / 작성자 닉네임과 회원 닉네임 얻기
	PostDTO pdto = pdao.getPost(post_no);
	MemberDTO nick = mdao.get(pdto.getPost_id());
	
	String post_id = pdto.getPost_id();
	String post_nick = nick.getMember_nick();
	
	String member_id = mdto.getMember_id();
	String member_nick = mdto.getMember_nick();
	
	boolean isAdmin = mdto.getAccess_auth().equals("운영자");
	boolean isMine = member_id.equals(post_id);
	boolean isPost_id = pdto.getPost_id() != null;
	
	// 댓글 읽어오기
	ReplyDAO rdao = new ReplyDAO();
	List<ReplyDTO> list = rdao.postReply(post_no);
	
%>

<jsp:include page="/template/header.jsp"></jsp:include>

<div align="center">
	<h2><%=pdto.getPost_title() %></h2>
	<table style="width: 1038px;"> 
		<tbody>
			<tr>
				<td colspan="6" align="right">
					<a href="create.jsp"><input type="button" value="글쓰기"></a>
					<%if(isAdmin || isMine) { %>
						<a href="edit_post.jsp?post_no=<%=pdto.getPost_no()%>"><input type="button" value="수정"></a>
						<a href="delete.do?post_no=<%=pdto.getPost_no()%>"><input type="button" value="삭제"></a>
					<%} %>
					<a href="board.jsp"><input type="button" value="목록"></a>
				</td>
			</tr>
			<tr>
				<th>말머리</th>
				<td height="80" colspan="2"><%=pdto.getPost_sub() %></td>
				<th>작성자</th>
				<%if(isPost_id) { %>
					<td height="80" colspan="2"><a href="<%=request.getContextPath()%>/member/userinfo.jsp?member_id=<%=pdto.getPost_id()%>"><%=post_nick%></a></td>
				<%} else {%>
					<td height="80" colspan="2"><font color="red" size="3"><i><b>탈퇴한 유저</b></i></font></td>
				<%} %>
			</tr>
			<tr>
				<td colspan="6">
					<hr>
				</td>
			</tr>
			<tr>
				<th>조회수</th>
				<td colspan="2" height="80"><%=pdto.getPost_hits() %></td>
				<th>작성일</th>
				<td colspan="2" height="80"><%=pdto.getPost_date() %>
			</tr>
			<tr>
				<td colspan="6">
					<hr>
				</td>
			</tr>
			<tr>
				<th>제목</th>
				<td colspan="6" height="80"><font size="5"><%=pdto.getPost_title() %></font></td>
			</tr>
			<tr>
				<td colspan="6">
					<hr>
				</td>
			</tr>
			<tr>
				<th>내용</th>
				<td width="300" height="250" colspan="6"><%=pdto.getPost_content() %></td>
			</tr>
			<tr>
				<td colspan="6">
					<hr>
				</td>
			</tr>
			<tr>
				<th>
					<br>
					<div style="font-size: 35px; text-align: left">댓글 <font size="4">(<%=rdao.replyCount(post_no) %>)</font></div>
					<br>
					
				</th>
			</tr>
			<tr>
				<td colspan="6">
					<table style="width: 1038px;">
						<tbody>
						<%if(list != null) { %>
							<%for(ReplyDTO rdto : list) { %>
								<%String reply_no = String.valueOf(rdto.getReply_no());%>
								<%MemberDTO reply_user = mdao.get(rdto.getReply_id()); %>
								<%boolean my_reply = member_id.equals(rdto.getReply_id()); %>
								<tr>
									<td width="1038">
									<form action="edit_reply.do" method="post">
										<table style="width: 1038px; height: 50px;  border: 1px solid gray">
											<tr>
												<td>
													<div style="color: green; font-size: 24px;">
														<b><a href="<%=request.getContextPath()%>/member/userinfo.jsp?member_id=<%=reply_user.getMember_id()%>"><%=reply_user.getMember_nick() %></a></b>
													</div>
												</td>	
												<td align="right">
													<%if(my_reply || mdto.getAccess_auth().equals("운영자")) { %>
														<%if (request.getParameter("edit") != null && request.getParameter("reply_no").equals(reply_no)) { %>
															<p><input type="submit" value="댓글 수정"></p>
														<%} else {%>
															<p><a href="post.jsp?post_no=<%=post_no%>&reply_no=<%=rdto.getReply_no() %>&edit"><input type="button" value="수정"></a> | <a href="delete_reply.do?reply_no=<%=rdto.getReply_no()%>&post_no=<%=post_no%>"><input type="button" value="삭제"></a></p>
														<%} %>
													<%} %>	
												</td>
												<td align="right" width="100">
													<div style="color: black; font-size: 15px;">
														<%=rdto.getReply_date() %>
													</div>
												</td>
											</tr>
											<tr>
												<td colspan="3">
													<hr>
												</td>
											</tr>
											<tr>		
												<td colspan="3" height="100">
													<%if(request.getParameter("edit") != null && request.getParameter("reply_no").equals(reply_no)) { %>
														<input type="hidden" name="post_no" value="<%=post_no %>">
														<input type="hidden" name="reply_no" value="<%=rdto.getReply_no() %>">
														<textarea rows="5" cols="144" name="reply_content"><%=rdto.getReply_content() %></textarea>
													<%} else { %>
														<div><%=rdto.getReply_content() %></div>
													<%} %>
												</td>
											</tr>
										</table>
									</form>
									<br>
									</td>
								</tr>
							<%} %>
						<%} %>	
							<tr>
								<td colspan="2">
									<hr>
									<br>
									<div style="font-size: 25px; text-align: left; font-style: italic;"><b>댓글 작성</b></div>

										<form action="create_reply.do" method="post">
											<div align="right" style="padding-bottom: 15px;">
											<input type="submit" value="등록">
											</div>
											<textarea rows="10" cols="145" name="reply_content"></textarea>
											<input type="hidden" name="post_no" value="<%=post_no%>">
											<input type="hidden" name="member_id" value="<%=mdto.getMember_id() %>">
									</form>
								</td>
							</tr>
						</tbody>
					</table>
				</td>
			</tr>
		</tbody>
		<tfoot>
			<tr>
				<td colspan="6" align="right">
					<a href="create.jsp"><input type="button" value="글쓰기"></a>
					<a href="create.jsp?post_no=<%=post_no%>"><input type="button" value="답글"></a>
					<%if(isAdmin || isMine) { %>
						<a href="edit_post.jsp?post_no=<%=pdto.getPost_no()%>"><input type="button" value="수정"></a>
						<a href="delete.do?post_no=<%=pdto.getPost_no()%>"><input type="button" value="삭제"></a>
					<%} %>
					<a href="board.jsp"><input type="button" value="목록"></a>
				</td>
			</tr>
		</tfoot>
	</table>
</div>

<jsp:include page="/template/footer.jsp"></jsp:include>