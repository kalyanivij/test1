
<script>
	function submitForm(nextPath) {
		var form = document.forms[0];

		form.action = nextPath;
		form.method = 'post';

		form.submit();
	}
</script>

<%
	String userName = " ";
%>
<center>

	<h3>
		Family Expense Report User:<%=session.getAttribute("username")%></h3>

</center>