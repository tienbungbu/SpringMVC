<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>add-product</title>
</head>
<body>
	<h1>Them product</h1>
	<c:url value="/add-product" var="url" />
	<form:form action="${url }" method="post" modelAttribute="product">
	<form:hidden path="id"/>
	<p>ten san pham: <form:input path="name"/> </p>
	<p>gia: <form:input path="price"/> </p>
	<p>so luong: <form:input path="quantity"/> </p>
	<br>
	<form:button value="submit">Submit</form:button>
	
	</form:form>
</body>
</html>