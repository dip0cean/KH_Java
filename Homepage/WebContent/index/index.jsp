<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- 페이지를 불러오기 위해서는 두 가지 방법이 존재(정적 include/ 동적 include) -->
<!-- - 서버에서 사용자에게 보내기 전에 실행되는 코드이기 때문에 절대경로 작성 시 프로젝트 이름이 생략되어 작성된다. -->

<!-- - 정적 include 란 "해당 파일의 코드를 복사 붙여넣기한 효과" 를 주는 코드이다. -->
<!-- - 다른 파일에서 작성한 내용도 불러오면 접근이 가능하다. > 의존성(종속성)이 강하다. -->

<!-- - 동적 include 란 "컴파일 이후의 코드를 임의로 합쳐서 적용시키는 효과" 를 주는 코드이다. -->


<%-- <%@ include file="/template/header.jsp" %> --%>
<jsp:include page="/template/header.jsp"></jsp:include>

<div align="center">
	<h3>환영합니다! 행복이 가득한 성헌의 숲에 오신 것을요!</h3>
	<img alt="동물의 숲" src="../image/성헌의 숲.png" width="750" height="300">
</div>

<%-- <%@ include file="/template/footer.jsp" %> --%>
<jsp:include page="/template/footer.jsp"></jsp:include>