<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta id="_csrf" name="_csrf" content="${_csrf.token}"/>
<!-- default header name is X-CSRF-TOKEN -->
<meta id="_csrf_header" name="_csrf_header" content="${_csrf.headerName}"/>
<meta http-equiv="Content-Type" content="charset=UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.2.1.min.js" integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4="
  crossorigin="anonymous"></script>
</head>
<body>
	<h1>form</h1>
	<form name="signupForm" action="/" >
	    <div>
	        <label >first</label>
	        <input />
	        <p>Validation error</p>
	    </div>
	    <div>
	        <label >last</label>
	        <input />
	        <p>Validation error</p>
	    </div>
	    <div>
	        <label >email</label>
	        <input name="email" required/>
	        <p>Validation error</p>
	    </div>
	    <div>
	        <label >password</label>
	        <input name="password" type="password" />
	        <p>Validation error</p>
	    </div>
	    <div>
	        <label >confirm</label>
	        <input type="password" />
	    </div>
	    <button type="submit" >submit</button>
	</form>	 
<a href="/login" >login</a>
</body>
<script>
	var csrf = {
		"token" : "${_csrf.token}",
		"headerName" : "${_csrf.headerName}"
	};
</script>
<script type="module" >

	import signup from "/js/user/signup.js";
	document.addEventListener("submit", signup);
</script>
</html>
