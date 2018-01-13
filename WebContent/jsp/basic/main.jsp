<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> --%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%-- <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> --%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>
	<sec:authorize>
		<sec:authentication property="name"/>님 안녕하세요.
	</sec:authorize>
	<form>
		<input type="text" value="Test">
		<button>입력</button>
	</form>	
</body>
<script type="module" src="/js/commons/myQuery.js"></script>
<!-- <script type="module" src="/js/auth/springSecurityLogin.js"></script> -->
<script>
	fetch("/main/main", {method: "post"})
		.then(res=>res.text())
		.then(console.log);		
</script>
</html>