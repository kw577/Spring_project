<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- spring tags - pozwala na korzystanie z dodatkowych funkcji zawartych w frameworku spring -->
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!-- Zostal tu wykorzystany szblon ze strony https://startbootstrap.com/template-categories/unstyled/ -->

<!-- tworzenie zmiennych wykorzystywanych do mapowania do lokalizacji plikow zawierajacych szablon frontendu - mapowanie w pliku dispatcher-servlet.xml -->
<!-- spring:     - oznacza ze tag korzysta z funkcjonalnosci z spring -->
<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />

<!-- c:   - oznacza ze korzystamy z funkcjonalnosci z biblioteki jstl -->
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!-- contextRoot to nazwa projektu - "onlineshopping"  -->
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<!--  zmienna title w pliku PageController.java  -->
<title>Online Shopping - ${title}</title>

<script>
	window.menu = '${title}';
	
	window.contextRoot = '${contextRoot}'
	
</script>


<!-- Bootstrap Core CSS -->
<link href="${css}/bootstrap.min.css" rel="stylesheet">

<!-- Bootstrap Readable Theme CSS  -->
<link href="${css}/bootstrap-readable-theme.css" rel="stylesheet">

<!-- Bootstrap DataTable CSS - wazna jest kolejnosc linkowania tyh plikow css  -->
<link href="${css}/dataTables.bootstrap.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="${css}/myapp.css" rel="stylesheet">


</head>

<body>

	<div class="wrapper">

		<!-- Navigation -->
		<%@include file="flows-navbar.jsp" %>

		<div class="content">