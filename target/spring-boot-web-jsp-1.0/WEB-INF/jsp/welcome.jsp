<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />
<c:url value="/css/main.css" var="jstlCss" />
<link href="${jstlCss}" rel="stylesheet" />

<script type='text/javascript'>

	function validateFileSize() {
		var input, file;

		input = document.getElementById('file');

		file = input.files[0];
		var filename = file.name
		var fileExt = filename.split('.').pop();
		var fileSize = file.size / (1024 * 1024);
		
		if (fileExt == 'txt' && fileSize < 200) {
			document.forms['uploadFile'].submit();
		} else {
			alert('!! Validation Error ::: Please select only (.txt) file with size limit 200 MB')
			return false;
		}
	}

	function bodyAppend(tagName, innerHTML) {
		var elm;
		elm = document.createElement(tagName);
		elm.innerHTML = innerHTML;
		document.body.appendChild(elm);
	}
</script>


</head>
<body>
	<div class="container">

		<div class="starter-template">
			<center><h1>Dictionary</h1></center>
			<form name="uploadFile" action="uploadFile" method="POST" enctype="multipart/form-data">
			<input type ="file" id="file" name= "getFileName" data-max-size="32154" required><br><br>
			<input type ="button" value="upload a file" onclick='validateFileSize();'/>
			</form>
		</div>

	</div>
	<script type="text/javascript"
		src="webjars/bootstrap/3.3.7/js/bootstrap.min.js">
	</script>

</body>

</html>
