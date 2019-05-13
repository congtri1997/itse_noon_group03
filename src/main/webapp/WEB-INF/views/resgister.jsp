<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<title>Bootstrap 4 Example</title>
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
	<!-- Grey with black text -->
	<nav class="navbar navbar-expand-sm bg-light navbar-light">
		<ul class="navbar-nav">
			<li class="nav-item active"><a class="nav-link" href="#">Giữa
					kì - chuyên đề web</a></li>
			<li class="nav-item"><a class="nav-link" href="#">Quản lý
					sinh viên</a></li>
		</ul>
	</nav>
	<div class="container">
		<div class="jumbotron">
			<h1>Quản lý thành viên</h1>
			<p>Thêm thông tin thành viên</p>
		</div>

		<c:url var="post_url" value="/registerSocialAccount" />

		<form:form id="formAddStudent" action="${post_url}" method="post"
			modelAttribute="formAddMember">
			<fieldset class="border p-3">
				<input type="hidden" name="providerID" value="${providerID}" /> <input
					type="hidden" name="providerUserID" value="${providerUserID}" />
				<legend class="w-auto">Thêm thông tin thành viên</legend>
				<div class="form-group row">
					<label for="email" class="col-2 col-form-label">*Địa chỉ
						email</label>
					<div class="col-10">
						<div class="input-group">
							<div class="input-group-prepend">
								<div class="input-group-text">
									<i class="fa fa-at"></i>
								</div>
							</div>
							<form:input id="email" path="email"
								placeholder="Vui lòng nhập email" type="text"
								aria-describedby="emailHelpBlock" class="form-control" />
						</div>
						<!-- 	<span id="emailHelpBlock" class="form-text text-muted"></span> -->
						<form:errors path="email" cssClass="form-text text-muted" />

					</div>
				</div>
				<div class="form-group row">
					<label for="userName" class="col-2 col-form-label">*Tài
						khoản</label>
					<div class="col-10">
						<div class="input-group">
							<div class="input-group-prepend">
								<div class="input-group-text">
									<i class="fa fa-at"></i>
								</div>
							</div>
							<form:input id="userName" path="userName"
								placeholder="Vui lòng nhập tên tài khoản" type="text"
								aria-describedby="userNameHelpBlock" class="form-control" />
						</div>
						<!-- 	<span id="emailHelpBlock" class="form-text text-muted"></span> -->
						<form:errors path="email" cssClass="form-text text-muted" />

					</div>
				</div>
				<div class="form-group row">
					<label for="password" class="col-2 col-form-label">Mật khẩu</label>
					<div class="col-10">
						<div class="input-group">
							<div class="input-group-prepend">
								<div class="input-group-text">
									<i class="fa fa-lock"></i>
								</div>
							</div>
							<form:password id="password" path="password"
								placeholder="Vui lòng nhập mật khẩu" class="form-control"
								aria-describedby="passwordHelpBlock" />
						</div>
						<!-- <span id="passwordHelpBlock" class="form-text text-muted"></span> -->
						<form:errors path="password" cssClass="form-text text-muted" />
					</div>
				</div>
				<div class="form-group row">
					<label for="confirmPassword" class="col-2 col-form-label">Xác
						nhận mật khẩu</label>
					<div class="col-10">
						<div class="input-group">
							<div class="input-group-prepend">
								<div class="input-group-text">
									<i class="fa fa-lock"></i>
								</div>
							</div>
							<form:password id="confirmPassword" path="confirmPassword"
								placeholder="Vui lòng nhập xác nhận mật khẩu"
								class="form-control" aria-describedby="confirmPasswordHelpBlock" />
						</div>
						<!-- 	<span id="passwordHelpBlock" class="form-text text-muted"></span> -->
						<form:errors path="confirmPassword"
							cssClass="form-text text-muted" />
					</div>
				</div>
				<div class="form-group row">
					<label for="lastName" class="col-2 col-form-label">*Họ</label>
					<div class="col-10">
						<div class="input-group">
							<div class="input-group-prepend">
								<div class="input-group-text">
									<i class="fas fa-user-circle"></i>
								</div>
							</div>
							<form:input id="lastName" path="lastName"
								placeholder="Vui lòng nhập họ tên" type="text"
								class="form-control" aria-describedby="lastNameHelpBlock" />
						</div>
						<!-- <span id="lastNameHelpBlock" class="form-text text-muted"></span> -->
						<form:errors path="lastName" cssClass="form-text text-muted" />
					</div>
				</div>
				<div class="form-group row">
					<label for="firstName" class="col-2 col-form-label">*Tên</label>
					<div class="col-10">
						<div class="input-group">
							<div class="input-group-prepend">
								<div class="input-group-text">
									<i class="fas fa-user-circle"></i>
								</div>
							</div>
							<form:input id="firstName" path="firstName"
								placeholder="Vui lòng nhập họ tên" type="text"
								class="form-control" aria-describedby="firstNameHelpBlock" />
						</div>
						<!-- <span id="lastNameHelpBlock" class="form-text text-muted"></span> -->
						<form:errors path="firstName" cssClass="form-text text-muted" />
					</div>
				</div>

				<div class="form-group row">
					<label for="dateOfBirth" class="col-2 col-form-label">*Ngày
						sinh</label>
					<div class="col-10">
						<div class="input-group">
							<div class="input-group-prepend">
								<div class="input-group-text">
									<i class="fa fa-birthday-cake"></i>
								</div>
							</div>
							<form:input id="dateOfBirth" path="dateOfBirth"
								placeholder="Vui lòng chọn ngày sinh" type="text"
								class="form-control" aria-describedby="dateOfBirthHelpBlock" />
						</div>
						<form:errors path="dateOfBirth" cssClass="form-text text-muted" />
					</div>
				</div>



				<div class="form-group row">
					<label for="phone" class="col-2 col-form-label">Số điện
						thoại</label>
					<div class="col-10">
						<div class="input-group">
							<div class="input-group-prepend">
								<div class="input-group-text">
									<i class="fas fa-mobile-alt"></i>
								</div>
							</div>
							<form:input id="phoneNumber" path="phoneNumber"
								placeholder="Vui lòng nhập số điện thoại" type="text"
								class="form-control" aria-describedby="phoneHelpBlock" />
						</div>
						<!-- <span id="phoneHelpBlock" class="form-text text-muted"></span> -->
						<form:errors path="phoneNumber" cssClass="form-text text-muted" />
					</div>
				</div>
				<div class="form-group row">
					<div class="offset-2 col-10">
						<button name="submit" type="submit" class="btn btn-primary">Lưu</button>
						<button type="button"
							onclick="location.href='<c:url value="/member/list"/>';"
							class="btn btn-danger">Hủy bỏ</button>
					</div>
				</div>
			</fieldset>
		</form:form>
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