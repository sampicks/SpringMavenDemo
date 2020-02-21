<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Yahoo!!!!!!!</title>
</head>
<body>
	<p>
		<font color="red"> ${errorMessage} </font>
	</p>
	<form action="/loginCheck" method="post">
		Enter your name&nbsp;&nbsp;&nbsp;&nbsp; <input type="text" name="name">
		<br /> Enter your Password <input type="password" name="password">
		<br /> <input type="submit" value="Login">

	</form>
</body>
</html>