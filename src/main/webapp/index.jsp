<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Developer Ranking | Login</title>
<style>
.errorblock {
	color: #ff0000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
}
</style>
<style>
.infoblock {
	color: #0000ff;
	background-color: #EEEEff;
	border: 3px solid #0000ff;
	padding: 8px;
	margin: 16px;
}
</style>
<script type="text/javascript">
	$('#toggle-login').click(function() {
		$('#login').toggle();
	});
</script>
<style type="text/css">
@import
	url(http://fonts.googleapis.com/css?family=Open+Sans:300,400,700);

* {
	margin: 0;
	padding: 0;
}

body {
	background: #567;
	font-family: 'Open Sans', sans-serif;
}

.button {
	width: 100px;
	background: #3399cc;
	display: block;
	margin: 0 auto;
	margin-top: 1%;
	padding: 10px;
	text-align: center;
	text-decoration: none;
	color: #fff;
	cursor: pointer;
	transition: background .3s;
	-webkit-transition: background .3s;
}

.button:hover {
	background: #2288bb;
}

#login {
	width: 400px;
	margin: 0 auto;
	margin-top: 8px;
	margin-bottom: 2%;
	transition: opacity 1s;
	-webkit-transition: opacity 1s;
}

#triangle {
	width: 0;
	border-top: 12x solid transparent;
	border-right: 12px solid transparent;
	border-bottom: 12px solid #3399cc;
	border-left: 12px solid transparent;
	margin: 0 auto;
}

#login h1 {
	background: #3399cc;
	padding: 20px 0;
	font-size: 140%;
	font-weight: 300;
	text-align: center;
	color: #fff;
}

#login h2 {
	background: #3399cc;
	padding: 0 0;
	font-size: 90%;
	font-weight: 100;
	text-align: center;
	color: #fff;
}

form {
	background: #f0f0f0;
	padding: 6% 4%;
}

input[type="email"],input[type="password"] {
	width: 92%;
	background: #fff;
	margin-bottom: 4%;
	border: 1px solid #ccc;
	padding: 4%;
	font-family: 'Open Sans', sans-serif;
	font-size: 95%;
	color: #555;
}

input[type="submit"] {
	width: 100%;
	background: #3399cc;
	border: 0;
	padding: 4%;
	font-family: 'Open Sans', sans-serif;
	font-size: 100%;
	color: #fff;
	cursor: pointer;
	transition: background .3s;
	-webkit-transition: background .3s;
}

input[type="submit"]:hover {
	background: #2288bb;
}
</style>
</head>
<body>
	<span href="#" class="button" id="toggle-login">Log in</span>
		
	<div id="login">
		<div id="triangle"></div>
		<h1>Log in</h1>
		<c:if test="${not empty error}">
		<div class="errorblock">
			Login error : Please try again.<br />Root Cause:
			${message}
		</div>
		
	</c:if>
	<c:if test="${not empty info}">
		<div class="infoblock">			
			${message}
		</div>
		
	</c:if>
		<form action="<c:url value="/j_spring_security_check" />"
			method="post">
			<input type="email" placeholder="Email" name="j_username" /> <input
				type="password" placeholder="Password" name="j_password" /> <input
				type="submit" value="Log in" />
		</form>
		<form><h2>
			 <a class = "button" id="link-forgot-passwd" href="<c:url value="/forgotPwd"/>">
  Forgot Password
  </a></h2>
		</form>
	</div>
</body>
</html>
