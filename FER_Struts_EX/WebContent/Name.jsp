<%@page import="com.rs.fer.bean.User"%>
<%@page import="com.rs.fer.service.FERServiceImpl"%>
<%@page import="com.rs.fer.service.FERService"%>
<%@taglib uri="WEB-INF/struts-html.tld" prefix="html"%>

<%
	FERService ferservice = new FERServiceImpl();
	session = request.getSession();
	int id = Integer.parseInt(session.getAttribute("id").toString());
	User user = ferservice.getUser(id);
%>
<html:form action="update">
	<table align='center' border='1' height='400px' width='250px'>
		<tr>
			<td colspan='2' align='center'>Update Personal Name Info</td>
		</tr>

		<tr>
			<td>First Name</td>
			<td><input type='text' name='firstName'
				value='<%=user.getFirst_name()%>'></td>
		</tr>
		<tr>
			<td>Middle Name</td>
			<td><input type='text' name='middleName'
				value='<%=user.getMiddle_name()%>'></td>
		</tr>
		<tr>
			<td>Last Name</td>
			<td><input type='text' name='lastName'
				value='<%=user.getLast_name()%>'></td>
		</tr>
		<tr>
			<td align='center' colspan='2'><input type='button' value='Next'
				onClick="javascript: submitForm('update.do?method=contact');">
				&nbsp; &nbsp;</td>
		</tr>
	</table>

</html:form>