<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>


<!DOCTYPE html>
<html>
<head>
<title>Nhập môn công nghệ phần mềm - chiều - nhóm 03</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="<c:url value="/resources/bootstrap-4.3.1/css/bootstrap.min.css" />">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/DataTables/datatables.css" />" />
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/fontawesome-free-5.8.1/css/all.css" />" />

</head>
<body>
	<!-- Grey with black text -->
	<nav class="navbar navbar-expand-sm bg-light navbar-light">
		<ul class="navbar-nav">
			<li class="nav-item active"><a class="nav-link" href="#">NMCNPM
					- Chiều - Nhóm 03</a></li>
			<li class="nav-item"><a class="nav-link" href="#">Quản lý
					thành viên</a></li>
		</ul>
	</nav>
	<div class="container">
		<div class="jumbotron">
			<h1>Quản lý thành viên</h1>
			<p>Danh sách thành viên</p>
		</div>

		<div class="row">
			<div class="col-md-12">
				<p>
					<button type="button"
						onclick="location.href='<c:url value="/member/add" />';"
						class="btn btn-success btn-block">
						<i class="fas fa-plus-square"></i> Thêm thông tin thành viên
					</button>
				</p>
			</div>
		</div>
		<div class="row">Tổng số thành viên ${fn:length(members)}</div>
		<table id="example" style="width: 100%">
			<thead>
				<tr>
					<th>ID</th>
					<th>Tài khoản</th>
					<th>Họ tên</th>
					<th>Ngày sinh</th>
					<th>Email</th>
					<!-- <th>Mật khẩu</th> -->
					<th>Số điện thoại</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${members}" var="item">
					<tr>
						<td>${item.ID }</td>
						<td>${item.userName }</td>
						<td>${item.fullName }</td>
						<td>${item.dateOfBirth }</td>
						<td>${item.email }</td>
				<%-- 		<td>${item.password }</td> --%>
						<td>${item.phone }</td>
					</tr>
				</c:forEach>


			</tbody>

		</table>

	</div>
	<script src="<c:url value="/resources/jquery/jquery-3.4.0.js" />"></script>

	<script
		src="<c:url value="/resources/bootstrap-4.3.1/js/bootstrap.js" />"></script>
	<script type="text/javascript"
		src="<c:url value="/resources/DataTables/datatables.js" />"></script>
	<script type="text/javascript"
		src="<c:url value="/resources/fontawesome-free-5.8.1/js/all.js" />"></script>
	<script type="text/javascript">
		$(document).ready(function() {

			$('#example').DataTable({

				'columnDefs' : [ {
					'targets' : 3, // column index (start from 0)
					'orderable' : false, // set orderable false for selected columns
				} ]
			});
		});
	</script>
</body>
</html>