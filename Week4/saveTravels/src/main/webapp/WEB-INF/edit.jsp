<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>




<body class ="d-flex justify-content-center fullwidth">

<h1>Save Travels</h1>
<a href="/expenses"> go to main</a> 

<h1>Edit an expense:</h1>
<div>

<form:form action="/process/update/${expense.id}" method="put" class="d-flex flex-column" modelAttribute="expense">
	<form:errors class="text-danger" path="name"/>
	<form:errors path="vendor" class="text-danger"/>
	<form:errors path="amount" class="text-danger" />
	<form:errors path="description" class="text-danger"/>

	<form:label path="name">Expense Name:</form:label>
	<form:input path="name" />


	<form:label path="vendor">Vendor:</form:label>
	<form:input path="vendor" />


	<form:label path="amount">Amount:</form:label>
	<form:input path="amount" />

	<form:label path="description">Description:</form:label>
	<form:textarea path="description" rows="5" cols="30"/>
	<input type="submit">
</form:form>	
	
</div>



</body>
</html>