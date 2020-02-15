<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<title>Todos for ${name}</title>
</head>
<body>
Hi ${username} <br/>
<H1>Your Todos</H1><br/>
 ${todoList}
 <br/>
 
 Click to <a href="/add-todo">Add</a> more Todos.
</body>
</html>