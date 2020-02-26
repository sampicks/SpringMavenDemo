<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sform"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add-Todo</title>

<link href="webjars/bootstrap/4.4.1/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body style="margin: 4px; padding: 40px">

	<div class="container">
		<!-- commandName="todo" is required to be bind from jsp hence it is added into modelmap in TodoController. -->
		<sform:form method="post" commandName="todo">
			<fieldset class="form-group">
				<sform:hidden path="id"/>
				<sform:label path="desc">Description</sform:label>
				<sform:input path="desc" type="text" class="form-control"
					required="required" />
				<sform:errors path="desc" cssClass="text-warning" />
			</fieldset>
			<button type="submit" class="btn btn-success">Submit</button>
		</sform:form>
	</div>

</body>
</html>