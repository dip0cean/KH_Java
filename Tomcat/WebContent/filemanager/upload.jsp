<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- 파일을 업로드하기 위한 form 구성 -->
<!-- get 으로 전송할 경우 "파일명" 이 전송된다. -->
<!-- post 로 전송해도 "파일명" 으로 전송된다. -->
<!-- multipart/form-data 로 인코딩 방식을 바꾸면 파일을 전송할 수 있게 된다. -->
<form action="upload2.do" method="post" enctype="multipart/form-data">
	<input type="text" name="uploader">
	<br><br>
	<input type="file" name="f" multiple="multiple" accept=".png , .gif , .jpg">
	<br><br>
	<input type="submit" value="업로드">
</form>