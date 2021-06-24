<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<h1> Thêm Sản Phẩm</h1>

<c:url value="/add-product" var="url" />
<form:form action="${url }" method="post" modelAttribute="productDTO">
	<form:hidden path="id"/>
	<p>
		Tên sản phẩm: <form:input path="name"/>
		<label style="color:red">
			<form:errors path="name"></form:errors>
		</label>
	</p>
	
	<p>
		Số lượng : <form:input path="quantity"/>
		<label style="color:red">
			<form:errors path="quantity"></form:errors>
		</label>
	</p>
	
	<p>
		Giá: <form:input path="price"/>
		<label style="color:red">
			<form:errors path="price"></form:errors>
		</label>
	</p>
	<form:button value="submit">Submit</form:button>
	
	
</form:form>