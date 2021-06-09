<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>View User</h1>
	<p> id: ${user.id} </p>
	<p> username: ${user.username} </p>
	<p> password: ${user.password} </p>
	<p> gender: ${user.gender} </p>
	<p> acceptAgreement: ${user.acceptAgreement} </p>
	<p>So thich:</p>
<c:forEach items="${user.favourites }" var="item">
	<p>${item }</p>
</c:forEach>
	 <p>Avatar: ${user.avatar.getOriginalFilename() } </p>
</body>
</html>