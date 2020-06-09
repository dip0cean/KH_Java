<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	<%
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
	%>

<jsp:include page="/template/header.jsp"></jsp:include>

<div align="center">
	<h2>회원가입 페이지</h2>
	<form action="">
		<table>
			<!-- 아이디 -->
			<tr>
				<th>
					아이디
				</th>
				<td>
					<input type="text" name="MEMBER_NAME" placeholder="영문 + 숫자 5 ~ 20자" size="30" required>
				</td>
			</tr>
			
			<!-- 패스워드 -->
			<tr>
				<th>
					패스워드
				</th>
				<td>
					<input type="password" name="MEMBER_PW" placeholder="영문 + 숫자 + 특수문자 8 ~ 16자" size="30" required>
				</td>
			</tr>
			
			<!-- 닉네임 -->
			<tr>
				<th>
					닉네임
				</th>
				<td>
					<input type="text" name="MEMBER_NICK" placeholder="한글 5 ~ 8자" size="30" required>
				</td>
			</tr>
			
			<!-- 주소 -->
			<tr>
				<th rowspan="3">
					주소
				</th>
				
			<!-- 우편번호 -->
				<td>
					<select name="MEMBER_BASE_ADDR" required>
						<option>선택</option>
						<option>서울</option>
						<option>경기</option>
						<option>강원</option>
						<option>충북</option>
						<option>충남</option>
						<option>전북</option>
						<option>전남</option>
						<option>경북</option>
						<option>경남</option>
						<option>제주</option>
					</select>
					<input type="text" name="MEMBER_POST" placeholder="우편번호" size="6" maxlength="6" required>
				</td>
			</tr>
			
			<!-- 기본 주소 -->
			<tr>
				<td>
					<input type="text" name="MEMBER_BASE_ADDR" placeholder="기본 주소" size="30" required>
				</td>
			</tr>
			<tr>
				<td>
					<input type="text" name="MEMBER_EXTRA_ADDR" placeholder="상세 주소" size="30" required>
				</td>
			</tr>
			
			<!-- 생년월일 -->
			<tr>
				<th>
					생년월일
				</th>
				<td>
					<!-- 연도 -->
					<select name="MEMBER_BIRTH" required>
					<option>연도</option>
					<%for(int i = year; i >= 1900; i--) { %>
						<option><%=i %></option>
						<%} %>
					</select>
				
					<!-- 월 -->
					<select name="MEMBER_BIRTH" required>
					<option>월</option>
					<%for(int i = 1; i <= 12; i++) { %>
						<option><%=i %></option>
						<%} %>
					</select>
				
					<!-- 일 -->
					<select name="MEMBER_BIRTH" required>
					<option>일</option>
					<%for(int i = 1; i <= 31; i++) { %>
						<option><%=i %></option>
						<%} %>
					</select>
				
				</td>
			</tr>
			
			<!-- 휴대전화 -->
			<tr>
				<th>
					휴대전화
				</th>
				<td>
					<select required>
						<option>선택</option>
						<option>SKT</option>
						<option>K T</option>
						<option>LGU</option>
						<option>알 뜰</option>
						
					</select>
					<input type="text" name="MEMBER_PHONE" size="20" maxlength="11" placeholder="휴대전화" required>
				</td>
			</tr>
			
			<!-- 자기소개 -->
			<tr>
				<th>
					자기소개
				</th>
				<td>
					<textarea name="MEMBER_INTRO" rows="10" cols="30" placeholder="자신을 소개해주세요!"></textarea>
				</td>
			</tr>
			<tr>
				<th colspan="2">
					<input type="submit" value="회원 가입">
				</th>
			<tr>
		</table>
	</form>
</div>
<jsp:include page="/template/footer.jsp"></jsp:include>