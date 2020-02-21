<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link href="webjars/bootstrap/4.4.1/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body style="margin: 4px; padding: 40px">
	<form action="/add-todo" method="post">
		<caption>Enter Description</caption>
		<br /> <input type="text" name="desc"> <br /> <input style="margin-top: 10px"
			type="submit" class="btn btn-success" value="Submit">
	</form>
</body>
</html>