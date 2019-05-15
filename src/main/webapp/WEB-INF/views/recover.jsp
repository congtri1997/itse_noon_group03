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
<style>
#logreg-forms .form-reset {
	display: block;
}
</style>
<title>SEGr02</title>
</head>
<body>
	<div id="logreg-forms">

		<form action="<c:url value="/recoverpassword" />" class="form-reset"
			method="post">
			<input type="email" id="resetEmail" name="email" class="form-control"
				placeholder="Email address" required autofocus>
			<button class="btn btn-primary btn-block" type="submit">Reset
				Password</button>
			<p>${message }</p>
			<a href="<c:url value="/login" />"><i class="fas fa-angle-left"></i>
				Back</a>
		</form>
	</div>

	<script src="<c:url value="/resources/jquery/jquery-3.4.0.js" />"></script>
	<script
		src="<c:url value="/resources/bootstrap-4.3.1/js/bootstrap.min.js" />"></script>
	<script src="<c:url value="/resources/fontawesomec-5.8.1/js/all.js" />"></script>
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