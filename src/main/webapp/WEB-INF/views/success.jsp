<%@page import="edu.hcmuaf.fit.itse.noon.group03.service.MemberService"%>
<%@page import="edu.hcmuaf.fit.itse.noon.group03.entity.Member"%>
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
	<%-- <%
		MemberService memberService = new MemberService();
		Member member = memberService.getMemberByUserName((String) session.getAttribute("user"));
	%>
	Bạn đã đăng nhập với tên ${sessionScope.user.email } và mật khẩu là
	${sessionScope.user.password }
	<%=member.getEmail()%> --%>

	${sessionScope.member }
	<button type="button"
		onclick="location.href='<c:url value="/logout"/>';">logout</button>
</body>
</html>