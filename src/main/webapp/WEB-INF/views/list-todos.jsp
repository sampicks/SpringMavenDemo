<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
Hi ${username}
<br />
<div class="container">
	<caption><springLocale:message code="todo.caption" /></caption>
	<table class="table table-striped">

		<thead>
			<tr>
				<th><springLocale:message code="todo.username" /></th>
				<th><springLocale:message code="todo.description" /></th>
				<th><springLocale:message code="todo.date" /></th>
				<th><springLocale:message code="todo.complete" /></th>
				<th></th>
			</tr>
		</thead>

		<tbody>
			<c:forEach items="${todoList}" var="todo">
				<tr>
				<td>${todo.user}</td>
					<td>${todo.desc}</td>
					<td><format:formatDate value="${todo.targetDate}"
							pattern="dd/MMM/yyyy" /></td>
					<td>${todo.done}</td>
					<td><a class="btn btn-primary"
						href="/update-todo?id=${todo.id}">Update</a> <a
						class="btn btn-danger" href="/delete-todo?id=${todo.id}">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>

<div>
	Click to <a class="btn btn-success" href="/add-todo">Add</a> more
	Todos.
</div>
<%@ include file="common/footer.jspf"%>