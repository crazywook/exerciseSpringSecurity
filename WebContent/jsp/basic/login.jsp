<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta id="_csrf" name="_csrf" th:content="${_csrf.token}"/>
<!-- default header name is X-CSRF-TOKEN -->
<meta id="_csrf_header" name="_csrf_header" th:content="${_csrf.headerName}"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script 
  src="https://code.jquery.com/jquery-3.2.1.min.js"
  integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4="
  crossorigin="anonymous"></script>
</head>
<body>
	<form name="loginForm" action="/test" method="post">
		<input name="username" autofocus>
		<input name="password" >	
		<button>로그인</button>
	</form>
	<br>
	
</body>

<script>
	var csrf = {
		"token" : "${_csrf.token}",
		"headerName" : "${_csrf.headerName}"
	};
</script>
<script defer type="module" src="/js/commons/myQuery.js"></script>
<script defer type="module" src="/js/auth/springSecurityLogin.js"></script>
<script>
	function encodePassword() {
		const password = "1234";
		
		$.get("/api/v0/user")
			.done(console.log)
			.fail(console.error);
	}
</script>
</html>
