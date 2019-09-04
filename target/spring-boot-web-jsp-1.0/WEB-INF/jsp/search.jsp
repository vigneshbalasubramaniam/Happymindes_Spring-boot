<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>

<link rel="stylesheet" type="text/css"
	href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />

<c:url value="/css/main.css" var="jstlCss" />
<link href="${jstlCss}" rel="stylesheet" />

</head>
<body>
	<div class="container">

		<div class="starter-template">
			<center><h1>Dictionary</h1></center>
			<form name="searchWord" action="searchWord" method="POST">
			Type the word to search in the dictionary:<input type ="text" name= "searchText" required><br><br>
			
			<input type ="submit" value="Submit & search" /><br><br>
			<h2>Search result:<h4>${searchResult}</h4><h2>
			</form>
		</div>

	</div>
	<!-- /.container -->

	<script type="text/javascript"
		src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>

</html>
