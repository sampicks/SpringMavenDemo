<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<div class="container">
	<p>
		<font color="red"> ${errorMessage} </font>
	</p>
	<form action="/loginCheck" method="post">
		Enter your name&nbsp;&nbsp;&nbsp;&nbsp; <input type="text" name="name">
		<br /> Enter your Password <input type="password" name="password">
		<br /> <input type="submit" value="Login">

	</form>
	</div>
		<%@ include file="common/footer.jspf"%>