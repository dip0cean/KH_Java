<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<jsp:include page="/template/header.jsp"></jsp:include>
<div align="center">
	<h2>회원가입 페이지</h2>
	
<!-- FORM 을 만들 때에는 전송 방식을 설정할 수 있다. -->
	<form action="join.do" method="get">
		<table>
			<!-- 아이디 -->
			<tr>
				<th>
					아이디
				</th>
				<td>
					<input type="text" name="member_id" placeholder="영문 + 숫자 5 ~ 20자" size="30" required>
				</td>
			</tr>
			
			<!-- 패스워드 -->
			<tr>
				<th>
					패스워드
				</th>
				<td>
					<input type="password" name="member_pw" placeholder="영문 + 숫자 + 특수문자 8 ~ 16자" size="30" required>
				</td>
			</tr>
			
			<!-- 닉네임 -->
			<tr>
				<th>
					닉네임
				</th>
				<td>
					<input type="text" name="member_nick" placeholder="한글 5 ~ 8자" size="30" required>
				</td>
			</tr>
			
			<!-- 주소 -->
			<tr>
				<th rowspan="3">
					주소
				</th>
				
			<!-- 우편번호 -->
				<td>
					<input type="text" name="member_post" placeholder="우편번호" size="30" maxlength="6" required>
				</td>
			</tr>
			
			<!-- 기본 주소 -->
			<tr>
				<td>
					<input type="text" name="member_base_addr" placeholder="기본 주소" size="30" required>
				</td>
			</tr>
			<tr>
				<td>
					<input type="text" name="member_extra_addr" placeholder="상세 주소" size="30" required>
				</td>
			</tr>
			
			<!-- 생년월일 -->
			<tr>
				<th>
					생년월일
				</th>
				<td>
					<input type="date" name="member_birth" required>			
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
					<input type="text" name="member_phone" size="20" maxlength="11" placeholder="휴대전화" required>
				</td>
			</tr>
			
			<!-- 자기소개 -->
			<tr>
				<th>
					자기소개
				</th>
				<td>
					<textarea name="member_intro" rows="10" cols="30" placeholder="자신을 소개해주세요!"></textarea>
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