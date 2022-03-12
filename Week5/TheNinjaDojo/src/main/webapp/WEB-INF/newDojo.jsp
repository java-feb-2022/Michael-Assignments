<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>


<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <title>Dojos and Ninjas</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/mystyle.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body class="d-flex justify-content-center fullwidth">
	<div class="d-flex flex-column align-items-center justify-content-center width80">
	
		<h1>New Dojo</h1>
		<div> <a href="/"> go to main </a> </div>
		<form:form action="/dojos/create" modelAttribute="dojo">
			<form:label path="name">Dojo Name:</form:label>
			<form:input path="name" /><br>
			<button class="btn btn-success">Create</button>
		</form:form>

	</div>
</body>
</html>