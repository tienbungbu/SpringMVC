<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c_rt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>


<a href=" <c_rt:url value= '/list-products'/> "> Quay lại </a>

<h1> Danh Sách Sản Phẩm</h1>

		<p> ${productDTO.id }</p>
		<p> ${productDTO.name }</p>
		<p> ${productDTO.quantity }</p>
		<p> ${productDTO.price }</p>
		