<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<title>Profile</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="<c:url value="/resources/bootstrap-4.3.1/css/bootstrap.min.css" />">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/fontawesome-free-5.8.1/css/all.css" />" />
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/bootstrap-datepicker-1.6.4/css/bootstrap-datepicker.css" />" />
</head>
<body>

	<nav class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-0">
		<a class="navbar-brand col-sm-3 col-md-2 mr-0" href="#">ITSE_Noon_Group03</a>
		<ul class="navbar-nav px-3">
			<li class="nav-item text-nowrap"><a class="nav-link"
				href="<c:url value="/logout"/>">Sign out</a></li>
		</ul>
	</nav>

	<div class="container-fluid">
		<div class="row">
			<nav class="col-md-2 d-none d-md-block bg-light sidebar">
				<div class="sidebar-sticky">
					<ul class="nav flex-column">
						<li class="nav-item"><a class="nav-link active" href="<c:url value="/profile/updateprofile"/>">
								<span data-feather="home"></span> Update profile <span
								class="sr-only">(current)</span>
						</a></li>
						<li class="nav-item"><a class="nav-link" href="<c:url value="/profile/changepassword"/>"> Change
								password </a></li>

					</ul>


				</div>
			</nav>

			<div class="col-md-10">${sessionScope.member }</div>

		</div>
	</div>

	<script src="<c:url value="/resources/jquery/jquery-3.4.0.js" />"></script>
	<script
		src="<c:url value="/resources/bootstrap-4.3.1/js/bootstrap.js" />"></script>
	<script type="text/javascript"
		src="<c:url value="/resources/fontawesome-free-5.8.1/js/all.js" />"></script>
	<script type="text/javascript"
		src="<c:url value="/resources/bootstrap-datepicker-1.6.4/js/bootstrap-datepicker.js" />"></script>
	<script type="text/javascript"
		src="<c:url value="/resources/jquery-validation-1.19.0\jquery.validate.js" />"></script>
	<!-- 	<script type="text/javascript">
		$.validator.addMethod("australianDate", function(value, element) {
			// put your own logic here, this is just a (crappy) example
			return value.match(/^\d\d?\/\d\d?\/\d\d\d\d$/);
		}, "Please enter a date in the format dd/mm/yyyy.");
		$.validator.setDefaults({
			highlight : function(element) {
				$(element).closest('.form-group').addClass('has-error');
			},
			unhighlight : function(element) {
				$(element).closest('.form-group').removeClass('has-error');
			},
			errorElement : 'span',
			errorClass : 'form-text text-danger',
			errorPlacement : function(error, element) {
				if (element.parent('.input-group').length) {
					error.insertAfter(element.parent());
				} else {
					error.insertAfter(element);
				}
			}
		});

		$(function() {
			$('#formAddStudent')
					.validate(
							{
								rules : {
									email : {
										required : true,
										email : true,
										remote : 'http://localhost:8080/15130202_NguyenCongTri_De02/restful/validateEmail'
									},
									fullName : "required",
									password : {
										required : true,
										minlength : 8
									},
									confirmPassword : {
										equalTo : "#password"
									},
									birthday : {
										required : true,
										australianDate : true
									}
								},
								messages : {
									fullName : "Bạn phải nhập họ tên",
									password : {
										required : "Bạn phải nhập mật khẩu",
										minlength : "Mật khẩu phải có độ dài tối thiểu là 8 kí tự"
									},
									confirmPassword : "Xác nhận mật khẩu không giống mật khẩu ban đầu",
									email : {
										required : "Bạn phải nhập email",
										email : "Bạn phải nhập đúng định dạng email",
										remote : "Email đã tồn tại"
									},
									birthday : {
										required : "Bạn phải nhập ngày sinh",
										australianDate : "Ngày sinh phải theo định dạng dd/mm/yyyy"
									}
								}
							});
		});
	</script> -->
</body>
</html>