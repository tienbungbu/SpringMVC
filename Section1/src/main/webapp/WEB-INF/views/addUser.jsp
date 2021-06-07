<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>add-user</title>
</head>
<body>
<h1>Them User</h1>
<c:url value="/add-user" var="url"/>
<form:form action="${url }" method="post" modelAttribute="user" >
<form:hidden path="id"/>
<p>Ten: <form:input path="name"/> <label style="color:red"> <form:errors path="name"></form:errors> </label> </p>

<p>Username: <form:input path="username"/> <label style="color:red"> <form:errors path="username"></form:errors> </label> </p>

<p>Password: <form:password path="password"/> <label style="color:red"> <form:errors path="password"></form:errors> </label>  </p>

<p>Role: 
<form:select path="role">
<form:option value="admin">Admin</form:option>
<form:option value="member">Member</form:option>
</form:select>
<br>
<form:button value="submit" >Submit</form:button>
 </p>
</form:form>

</body>
</html>