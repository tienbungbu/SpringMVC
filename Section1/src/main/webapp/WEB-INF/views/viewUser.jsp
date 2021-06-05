<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>viewUser</title>
</head>
<body>
		<h1>view User</h1>
		<p>id: ${user.id }</p>
		<p>name: ${user.name }</p>
		<p>username: ${user.username }</p>
		<p>password: ${user.password }</p>
		<p>role: ${user.role }</p>
</body>
</html>