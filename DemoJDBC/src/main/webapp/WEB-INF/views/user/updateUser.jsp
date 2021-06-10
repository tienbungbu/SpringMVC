<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c_rt" %>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Sửa thông tin người dùng</h1>
	<c_rt:url value="/update-user" var="url" />
	<form:form action="${url }" method="post" modelAttribute="user">
		<form:hidden path="id"/>
		<p> Họ và tên : <form:input path="name"/> <label style="color:red"> 
		<form:errors path="name"></form:errors> </label> </p> 
		<p> Số điện thoại : <form:input path="phoneNumber"/> <label style="color:red"> 
		<form:errors path="phoneNumber"></form:errors> </label> </p> 
		<form:button value="submit">Submit</form:button>
	</form:form>
</body>
</html>