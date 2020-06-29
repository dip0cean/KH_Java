<%@page import="homepage.beans.dto.PostFileDTO"%>
<%@page import="homepage.beans.dao.PostFileDAO"%>
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
	
	// 파일 목록 불러오기
	PostFileDAO pfdao = new PostFileDAO();
	List<PostFileDTO> filelist = pfdao.getList(post_no);
	
%>

<jsp:include page="/template/header.jsp"></jsp:include>
<article class="w-100">
	<div class="row-empty"></div>
	<div class="row-empty"></div>
	<div class="row-empty"></div>
	
	<div class="row">
		<table class="mypage form-input">
			<thead>
				<tr>
					<th colspan="6">
						<h2 class="title"><%=pdto.getPost_title() %></h2>
					</th>
				</tr>
				<tr>
					<td colspan="6" align="right">
						<a href="create.jsp"><input type="button" class="btm" value="글쓰기"></a>
						<a href="create.jsp?post_no=<%=post_no%>"><input type="button" class="btm" value="답글"></a>
						<%if(isAdmin || isMine) { %>
							<a href="edit_post.jsp?post_no=<%=pdto.getPost_no()%>"><input type="button" class="btm" value="수정"></a>
							<a href="delete.do?post_no=<%=pdto.getPost_no()%>"><input type="button" class="btm" value="삭제"></a>
						<%} %>
						<a href="board.jsp"><input type="button" class="btm" value="목록"></a>
					</td>
				</tr>
			</thead> 
			<tbody>
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
					<th>내용</th>
					<td height="250" colspan="6"><%=pdto.getPost_content() %></td>
				</tr>
				<tr>
					<td colspan="6">
						<hr>
					</td>
				</tr>
				<%if(!filelist.isEmpty()) { %>
					<tr>
						<th>
							첨부 파일
						</th>
						<td colspan="6" height="80">
							<ul>
								<%for(PostFileDTO pfdto : filelist) { %>
								<li>
									<%=pfdto.getPost_file_name() %> 
									(<%=pfdto.getPost_file_size() %> bytes)
									<a href="download.do?post_file_no=<%=pfdto.getPost_file_no()%>"><input type="image" src="<%=request.getContextPath()%>/image/download.png" width="15" height="15"></a>
								</li>
								<%} %>
							</ul>
						</td>
					</tr>
					<tr>
						<td colspan="6">
							<hr>
						</td>
					</tr>
				<%} %>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="6" align="right">
						<a href="create.jsp"><input type="button" class="btm" value="글쓰기"></a>
						<a href="create.jsp?post_no=<%=post_no%>"><input type="button" class="btm" value="답글"></a>
						<%if(isAdmin || isMine) { %>
							<a href="edit_post.jsp?post_no=<%=pdto.getPost_no()%>"><input type="button" class="btm" value="수정"></a>
							<a href="delete.do?post_no=<%=pdto.getPost_no()%>"><input type="button" class="btm" value="삭제"></a>
						<%} %>
						<a href="board.jsp"><input type="button" class="btm" value="목록"></a>
					</td>
				</tr>
			</tfoot>
		</table>
	</div>
	
	<div class="row-empty"></div>
	<div class="row-empty"></div>
	
	<!-- 댓글 영역 -->
	<div class="row">
			<table class="reply form-input">
				<thead>
					<tr>
						<th>
							<div style="font-size: 35px; text-align: left">댓글 <font size="4">(<%=rdao.replyCount(post_no) %>)</font></div>
							<br>
						</th>
					</tr>
				</thead>
				<tbody>
					<%if(list != null) { %>
						<%for(ReplyDTO rdto : list) { %>
							<%String reply_no = String.valueOf(rdto.getReply_no());%>
							<%MemberDTO reply_user = mdao.get(rdto.getReply_id()); %>
							<%boolean my_reply = member_id.equals(rdto.getReply_id()); %>
							<tr>
								<td>
									<form action="edit_reply.do" method="post">
										<table class="form-input">
											<tr>
												<td>
													<div style="font-size: 24px;">
														<b><a href="<%=request.getContextPath()%>/member/userinfo.jsp?member_id=<%=reply_user.getMember_id()%>"><%=reply_user.getMember_nick() %></a></b>
													</div>
												</td>	
												<td align="right">
													<%if(my_reply || mdto.getAccess_auth().equals("운영자")) { %>
														<%if (request.getParameter("edit") != null && request.getParameter("reply_no").equals(reply_no)) { %>
															<p><input type="submit" class="btm" value="댓글 수정"></p>
														<%} else {%>
															<p>
																<a href="post.jsp?post_no=<%=post_no%>&reply_no=<%=rdto.getReply_no() %>&edit"><input type="button" class="btm" value="수정"></a>
																<a href="delete_reply.do?reply_no=<%=rdto.getReply_no()%>&post_no=<%=post_no%>"><input type="button" class="btm" value="삭제"></a>
															</p>
														<%} %>
													<%} %>	
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
														<textarea class="reply-input" name="reply_content"><%=rdto.getReply_content() %></textarea>
													<%} else { %>
														<div class="w-100"><%=rdto.getReply_content() %></div>
													<%} %>
												</td>
											</tr>
											<tr>
												<td colspan="3" align="right">
													<div>
														<%=rdto.getReply_date() %>
													</div>
												</td>
											</tr>
										</table>
									</form>
									<br>
								</td>
							</tr>
						<%} %>
					<%} %>	
			</tbody>
			<tfoot>		
				<tr>
					<td class="center" colspan="2">
						<div style="font-size: 25px; text-align: left; font-style: italic;"><b>댓글 작성</b></div>
						<br>
						<form class="form-input reply-input" action="create_reply.do" method="post">
							<div class="row">
								<textarea class="reply-input" name="reply_content"></textarea>
							</div>
							<input type="hidden" name="post_no" value="<%=post_no%>">
							<input type="hidden" name="member_id" value="<%=mdto.getMember_id() %>">
							<div class="row" align="right">
								<input type="submit" class="btm" value="등록">
							</div>
						</form>
					</td>
				</tr>
				<tr>
					<td class="center" colspan="2">
					</td>
				</tr>
			</tfoot>	
		</table>
	</div>
	
	<div class="row-empty"></div>
	<div class="row-empty"></div>
	<div class="row-empty"></div>
</article>
<jsp:include page="/template/footer.jsp"></jsp:include>