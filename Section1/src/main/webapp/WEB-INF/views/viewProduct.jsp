<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>view Product</title>
</head>
<body>
	<h1>view Product</h1>
	<p>id: ${product.id } </p>
	<p>ten san pham: ${product.name } </p>
	<p>gia: ${product.price } </p>
	<p>so luong: ${product.quantity } </p>
</body>
</html>