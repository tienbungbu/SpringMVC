<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<h1>Register</h1>
		<c:url value="/add-user" var="url" />
		<form:form action="${url }" method="post" modelAttribute="user" enctype="multipart/form-data">
			<form:hidden path="id"/>
			<p>Ho va ten: <form:input path="name"/>  <label style="color:red"> <form:errors  path="name"></form:errors> </label>   </p>  
			<p>username: <form:input path="username"/>  <label style="color:red"> <form:errors path="username"></form:errors> </label>   </p>
			<p>password: <form:input path="password"/>  <label style="color:red"> <form:errors path="password"></form:errors> </label>   </p> 
			<p>so thich: </p>  
			<form:checkbox path="favourites" value="nghenhac" label="Nghe Nhac"/>
			<form:checkbox path="favourites" value="xemphim" label="Xem Phim"/>
			<form:checkbox path="favourites" value="code" label="Coding"/>
			<p>Gioi tinh</p>
			<form:select path="gender">
				<form:option value="nam">Nam</form:option>
				<form:option value="nu">Nu</form:option>
			</form:select>
			<br>
			<form:input type="file"  path="avatar"/>
			<br>
			<form:radiobutton path="acceptAgreement" label="Dong Y Dieu Khoan Su Dung" value="true"/>
			<br>
			 <form:button value="submit">Submit</form:button>
		</form:form>
</body>
</html>