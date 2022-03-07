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
<link rel="stylesheet" type="text/css" href="/css/mystyle.css">
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>


</head>
<body class="d-flex justify-content-center fullwidth">


<h1>Expense Details</h1>
<a href="/expenses"> Index </a>

<table class="table">
	<tr>
		<th> Expense Name:</th>
		<td> ${item.name} </td>
	</tr>
	
	<tr>
		<th> Expense Description:</th>
		<td> ${item.description} </td>
	</tr>
	
	<tr>
		<th> Vendor </th>
		<td> ${item.vendor} </td>
	</tr>
	
	<tr>
		<th> Amount </th>
		<td> ${item.amount} </td>
	</tr>


</table>



</body>
</html>