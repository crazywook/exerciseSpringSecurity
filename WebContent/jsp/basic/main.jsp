<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> --%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%-- <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> --%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/layout.css" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>	
	<div class="container">
		<header>			
			<div class="infoBar" >
				<sec:authorize access="hasRole('USER')">
					<sec:authentication property="name"/>님 안녕하세요.
				</sec:authorize>
				<form action="/search">
					<input type="text" value="Test">
					<button>검색</button>
				</form>	
			</div>
		</header>
		<div class="center">
			<aside></aside>
			<section role="main" ></section>
		</div>
	</div>
</body>
<script type="module" src="/js/commons/myQuery.js"></script>
<script type="module" src="/js/view/router.js"></script>
<script type="module">
	import route from "../commons/js/view/router.js";
	"use strict";
	$("form").submit(e=>e.preventDefault());	
	
	route("/jsp/member/memberList.jsp?payType=임금");	
</script>

</html>