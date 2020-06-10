<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
					</td>
				</tr>
				
				<!-- foot -->
				<tr height="100">
					<td align="center">
						<h5>
							<i>KH 정보 교육원 디바이스 / 웹 콘텐츠 융합 디지털 컨버전스 양성 과정</i>
						</h5>
						<!-- 사용자의 로그인 정보를 분석하는 코드 작성(연습용) -->
						<h6>
							세션 ID : <%=session.getId() %> <br>
							UserInfo : <%=session.getAttribute("userinfo") %> <br>
							state : <%=session.getAttribute("userinfo") != null %>
						</h6>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
</body>
</html>