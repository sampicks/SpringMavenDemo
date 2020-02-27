<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<div class="container">
	<!-- commandName="todo" is required to be bind from jsp hence it is added into modelmap in TodoController. -->
	<sform:form method="post" commandName="todo">
		<sform:hidden path="id" />
		<fieldset class="form-group">
			<sform:label path="desc">Description</sform:label>
			<sform:input path="desc" type="text" class="form-control"
				required="required" />
			<sform:errors path="desc" cssClass="text-warning" />
		</fieldset>

		<sform:label path="targetDate">Target Date</sform:label>
		<sform:input path="targetDate" type="text" class="form-control"
			required="required" />
		<sform:errors path="targetDate" cssClass="text-warning" />
		</fieldset>
		<button type="submit" class="btn btn-success">Submit</button>
	</sform:form>
</div>

<%@ include file="common/footer.jspf"%>