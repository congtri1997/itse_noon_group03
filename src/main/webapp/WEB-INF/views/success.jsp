<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Đăng ký thành công</title>
</head>
<body>
	Bạn đã đăng nhập với tên ${member.email } và mật khẩu là
	${member.password }
	<button type="button"
		onclick="location.href='<c:url value="/member/list"/>';">Quay
		lại</button>
</body>
</html>