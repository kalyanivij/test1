<%@page import="com.rs.fer.bean.User"%>
<%@page import="com.rs.fer.service.FERServiceImpl"%>
<%@page import="com.rs.fer.service.FERService"%>
<%@taglib uri="WEB-INF/struts-html.tld" prefix="html"%>

<%
	session = request.getSession();
	int userId = Integer.parseInt(session.getAttribute("id").toString());
	User user = (User) session.getAttribute("user");
	
%>
<html:form action="update">
	<table align='center' border='1' height='400px' width='250px'>
		<tr>
			<td colspan='2' align='center'>Update ContactInfo</td>
		</tr>

		<tr>
			<td>Email Id</td>
			<td><input type='email' name='emailId'
				value='<%=user.getEmail()%>'></td>
		</tr>
		<tr>
			<td>Mobile Number</td>
			<td><input type='text' name='mobileNumber'
				value='<%=user.getMobile_number()%>'></td>
		</tr>
		<tr>
			<td align='center' colspan='2'><input type='button' value='Next'
				onClick="javascript: submitForm('update.do?method=address');">
				&nbsp; &nbsp;</td>
		</tr>
	</table>
</html:form>
