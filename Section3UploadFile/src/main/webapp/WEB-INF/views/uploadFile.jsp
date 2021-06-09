<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>upload-file</title>
</head>
<body>
	<h1>Upload File</h1>
	<c:url value="/upload" var="url" />
		<form action="${url }" method="post" enctype="multipart/form-data" >
	<input type="file" name="file">
	<button value="submit">Submit</button>
		</form>
</body>
</html>