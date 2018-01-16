<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> --%>
<%-- <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> --%>
<!doctype html>
<html style="height: 100%;">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="/commons/js/util/import.js"></script>
<link rel="stylesheet" href="/commons/css/layout.css" />
<link rel="stylesheet" href="jsp/basic/index.css" />
<style>
	body, html {
		height: 100%;
	}
</style>
</head>
<body>
	<div class="flex middle">
		<button>Get Started</button>
	</div>
</body>
<script src="jsp/basic/index.js" ></script>
<script>
	document.querySelector("button").addEventListener("click", function(e){
		location.href="/main";
	});
</script>
</html>
