<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c_rt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<h1> Danh Sách Sản Phẩm</h1>

<a href=" <c_rt:url value= '/add-product'/> "> Thêm sản phẩm </a>

<table border="1">
	<tr>
		<th>ID</th>
		<th>Tên Sản Phẩm</th>
		<th>Số lượng</th>
		<th>Giá</th>
		<th>Chức năng</th>
	</tr>
	<c_rt:forEach items="${products}" var="p" >
	<tr>
		<td>${p.id }</td>
		<td>${p.name }</td>
		<td>${p.quantity }</td>
		<td>${p.price }</td>
		
		<td> 
			<a href=" <c_rt:url value="/detail-product/${p.id}"/> " > Chi tiết | </a>
			<a href=" <c_rt:url value="/edit-product/${p.id}"/> " > Sửa |</a>
			<a href=" <c_rt:url value="/delete-product/${p.id}"/> " > Xóa </a>
		
		</td>
	</tr>
	</c_rt:forEach>
	

</table>