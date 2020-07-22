<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%--
		JSTL 반복 태그
	 --%>
	 
	 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	 <c:forEach var="i" begin="1" end="10" step="1" >
	 	<h1>${i}</h1>
	 </c:forEach>
	 
	 <%--
	 	JSTL 확장 반복 태그
	 	String[] arr = new String[]{"java","jsp","spring","oracle","html"};
	 	for(String name : arr) {
	 	
	 	}
	  --%>
	  <c:set var="arr" value="java,jsp,spring,oracle,html"></c:set>
	  <c:forEach var="name" items="${arr }">
	  	<h2>${name }</h2>
	  </c:forEach>
</body>
</html>