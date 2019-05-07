<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>


<!DOCTYPE html>
<html>
<head>
<title>Bootstrap 4 Example</title>
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
			<li class="nav-item active"><a class="nav-link" href="#">Giữa
					kì - chuyên đề web</a></li>
			<li class="nav-item"><a class="nav-link" href="#">Quản lý
					sinh viên</a></li>
		</ul>
	</nav>
	<div class="container">
		<div class="jumbotron">
			<h1>Quản lý thành viên</h1>
			<p>Danh sách thành viên</p>
		</div>
		<div class="row">Tổng số thành viên ${fn:length(members)}</div>
		<table id="example" style="width: 100%">
			<thead>
				<tr>
					<th>Họ tên</th>
					<th>Ngày sinh</th>
					<th>Địa chỉ</th>
					<th>Email</th>
					<th>Thao tác</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${members}" var="item">
					<tr>
						<td>${item.fullName }</td>
						<td>${item.birthday }</td>
						<td>${item.address }</td>
						<td>${item.email }</td>
						<td>
							<button type="button" class="btn btn-primary btn-sm">
								<i class="fas fa-list"></i>
							</button>
						</td>
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
					'targets' : 4, // column index (start from 0)
					'orderable' : false, // set orderable false for selected columns
				} ]
			});
		});
	</script>
</body>
</html>