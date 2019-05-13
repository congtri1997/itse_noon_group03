<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<link rel="stylesheet"
	href="<c:url value="/resources/bootstrap-4.3.1/css/bootstrap.min.css" />">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/fontawesome-free-5.8.1/css/all.css" />" />
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/style.css" />" />
<title>SEGr02</title>
</head>
<body>
	<div id="logreg-forms">
		<form class="form-signin"
			action="<c:url var="post_url" value="/login" />" method="post">
			<h1 class="h3 mb-3 font-weight-normal" style="text-align: center">
				Sign in</h1>
			<div class="social-login">
				<!-- <a  class="btn facebook-btn social-btn" href="https://www.facebook.com/dialog/oauth?client_id=359123991240252&redirect_uri=https://localhost:8443/AccessFacebook/login-facebook"><span><i class="fab fa-facebook-f"></i> Sign in with
						Facebook</span></a> -->
				<button
					onclick="location.href='https://www.facebook.com/dialog/oauth?client_id=1291754064336511&scope=email&redirect_uri=http://localhost:8443/itse_noon_group03/LoginController?LoginType=fb'"
					class="btn facebook-btn social-btn" type="button">
					<span><i class="fab fa-facebook-f"></i>Sign in with Facebook</span>
				</button>
				<button
					onclick="location.href='https://accounts.google.com/o/oauth2/auth?scope=profile email&redirect_uri=https://localhost:8443/itse_noon_group03/LoginController?LoginType=google&response_type=code&client_id=1047932472616-4l3car2t55h2d9gu51gfafl5ejfhangu.apps.googleusercontent.com&approval_prompt=force'"
					class="btn google-btn social-btn" type="button">
					<span><i class="fab fa-google-plus-g"></i> Sign in with
						Google+</span>
				</button>
			</div>
			<p style="text-align: center">OR</p>
			<input type="text" id="inputUserName" name="userName"
				class="form-control" placeholder="UserName"> <input
				type="password" name="password" id="inputPassword"
				class="form-control" placeholder="Password">
			<p style="color: red">${loginError }</p>
			<%-- 		<%
				if (request.getAttribute("errorUserName") != null) {
			%>
			<p style="color: red;"><%=request.getAttribute("errorUserName")%>
			</p>
			<%
				}
			%>
			<%
				if (request.getAttribute("errorUserName") != null) {
			%>
			<p style="color: red;"><%=request.getAttribute("errorPassword")%>
			</p>
			<%
				}
			%> --%>
			<button class="btn btn-success btn-block" type="submit">
				<i class="fas fa-sign-in-alt"></i> Sign in
			</button>
			<a href="<c:url value="/recoverpassword" />">Forgot password?</a>
			<hr>
			<!-- <p>Don't have an account!</p>  -->
			<button class="btn btn-primary btn-block" type="button"
				onclick="location.href='<c:url value="/member/add"/>';"
				>
				<i class="fas fa-user-plus"></i> Sign up New Account
			</button>


		</form>

		<form action="/reset/password/" class="form-reset">
			<input type="email" id="resetEmail" class="form-control"
				placeholder="Email address" required autofocus>
			<button class="btn btn-primary btn-block" type="submit">Reset
				Password</button>
			<a href="#" id="cancel_reset"><i class="fas fa-angle-left"></i>
				Back</a>
		</form>

		<form action="/signup/" class="form-signup">
			<div class="social-login">
				<button class="btn facebook-btn social-btn" type="button">
					<span><i class="fab fa-facebook-f"></i> Sign up with
						Facebook</span>
				</button>
			</div>
			<div class="social-login">
				<button class="btn google-btn social-btn" type="button">
					<span><i class="fab fa-google-plus-g"></i> Sign up with
						Google+</span>
				</button>
			</div>

			<p style="text-align: center">OR</p>

			<input type="text" id="user-name" class="form-control"
				placeholder="Full name" required autofocus> <input
				type="email" id="user-email" class="form-control"
				placeholder="Email address" required autofocus> <input
				type="password" id="user-pass" class="form-control"
				placeholder="Password" required autofocus> <input
				type="password" id="user-repeatpass" class="form-control"
				placeholder="Repeat Password" required autofocus>

			<button class="btn btn-primary btn-block" type="submit">
				<i class="fas fa-user-plus"></i> Sign Up
			</button>
			<a href="#" id="cancel_signup"><i class="fas fa-angle-left"></i>
				Back</a>
		</form>
		<br>

	</div>
	<!--  <p style="text-align:center">
        <a href="http://bit.ly/2RjWFMfunction toggleResetPswd(e){
    e.preventDefault();
    $('#logreg-forms .form-signin').toggle() // display:block or none
    $('#logreg-forms .form-reset').toggle() // display:block or none
}

function toggleSignUp(e){
    e.preventDefault();
    $('#logreg-forms .form-signin').toggle(); // display:block or none
    $('#logreg-forms .form-signup').toggle(); // display:block or none
}

$(()=>{
    // Login Register Form
    $('#logreg-forms #forgot_pswd').click(toggleResetPswd);
    $('#logreg-forms #cancel_reset').click(toggleResetPswd);
    $('#logreg-forms #btn-signup').click(toggleSignUp);
    $('#logreg-forms #cancel_signup').click(toggleSignUp);
})g" target="_blank" style="color:black">By Artin</a>
    </p> -->
	<script src="<c:url value="/resources/jquery/jquery-3.4.0.js" />"></script>
	<script
		src="<c:url value="/resources/bootstrap-4.3.1/js/bootstrap.min.js" />"></script>
	<script src="<c:url value="/resources/fontawesomec-5.8.1/js/all.js" />"></script>
	<script src="<c:url value="/resources/js/script.js" />"></script>
</body>
</html>


<!-- <Connector port="8443" protocol="org.apache.coyote.http11.Http11NioProtocol"
        maxThreads="150" SSLEnabled="true"
                
        sslProtocol="TLS"
        schema="https"
        secure="true"
        keystoreFile="C:\ssl\Mycert.cert"
        keystorePass="113113"
        >
        
</Connector> -->