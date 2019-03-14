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

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

	<div class="wrapper">

		<!-- Navigation - w tym miejscu jest wstawiony kod z pliku navbar.jsp -->
		<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
			<div class="container">
				<div class="navbar-header">
					<a class="navbar-brand" href="${flowExecutionUrl}&_eventId_home">Home</a>
				</div>
			</div>
		</nav>

		<div class="content">
			<div class="container">
			
				<h3>This will be trigger by flow!</h3>
			
			</div>

		</div>

		<!-- Footer - w tym miejscu jest wstawiony kod z pliku footer.jsp -->
		<%@include file="../../shared/footer.jsp"%>

		<!-- Korzysta ze zmiennych utworzonych np w  <spring:url var="js" value="/resources/js"/>  -->
		<!-- jQuery -->
		<script src="${js}/jquery.js"></script>
		
		<!-- jQuery validator -->
		<script src="${js}/jquery.validate.js"></script>

		<!-- Bootstrap Core JavaScript -->
		<script src="${js}/bootstrap.min.js"></script>

		<!-- DataTable Plugin - jQuery - tabela do wyswietlania produktow -->
		<script src="${js}/jquery.dataTables.js"></script>

		<!-- DataTable Bootstrap Script - jQuery - tabela do wyswietlania produktow - wazna jest kolejnosc linkowania tych plikow .js-->
		<script src="${js}/dataTables.bootstrap.js"></script>

		<!-- DBootbox - okno dialogowe -->
		<script src="${js}/bootbox.min.js"></script>

		<!-- Self coded javascript - Active menu - podswietlanie aktualnie wybranej opcji na pasku nawigacji -->
		<script src="${js}/myapp.js"></script>

	</div>

</body>

</html>