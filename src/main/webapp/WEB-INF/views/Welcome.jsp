<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<div class="container">
	<springLocale:message code="welcome.message" /> ${username} <br /> <springLocale:message code="welcome.authenticated" /><a
		href="/list-todos">Click here</a> to start maintaining your todo's.

	<%@ include file="common/footer.jspf"%>