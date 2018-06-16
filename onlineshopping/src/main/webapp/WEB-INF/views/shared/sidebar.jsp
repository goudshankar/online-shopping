<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<p class="my-4">Shop Name</p>
<div class="list-group">
	<c:forEach items="${categories}" var="category">
	<a href="#" class="list-group-item">${category.name}</a>
	</c:forEach>
	
	
	
	
	<%-- <c:forEach items="${categories}" var="category">
		<a href="#" class="list-group-item">${category.name}</a>
		<a href="#" class="list-group-item">${category.name}</a>
		<a href="#" class="list-group-item">${category.name}</a>
		</c:forEach> --%>
</div>