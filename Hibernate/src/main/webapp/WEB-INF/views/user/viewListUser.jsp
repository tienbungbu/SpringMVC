<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c_rt" %>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

	<h1>Danh Sách Người Dùng</h1>
	<a href=" <c_rt:url value='/add-user' /> ">  Thêm Người Dùng </a>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>TEN_KH</th>
			<th>SDT</th>
			<th>Action</th>
		</tr>
	<c_rt:forEach items="${users }" var="user" >
	<tr>
			
			<td>${user.id }</td>
			<td>${user.name }</td>
			<td>${user.phoneNumber }</td>
			<td> 
				<a href=" <c_rt:url value='/detail-user/${user.id }' /> "> Chi Tiết </a>  
				<a href=" <c_rt:url value='/update-user/${user.id }' /> "> | Sửa </a> 
				<a href=" <c_rt:url value='/delete-user/${user.id }' /> "> | Xóa </a> 
			</td>
		</tr>	
	</c_rt:forEach>
		
	</table>
