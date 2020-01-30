<%@page import="com.rs.fer.bean.User"%>
<%@page import="com.rs.fer.service.FERServiceImpl"%>
<%@page import="com.rs.fer.service.FERService"%>
<%@taglib uri="WEB-INF/struts-html.tld" prefix="html"%>

<%
	session = request.getSession();
	int id = Integer.parseInt(session.getAttribute("id").toString());
	User user = (User) session.getAttribute("user");
	
%>
<html:form action="update">
	<table align='center' border='1' height='400px' width='250px'>
		<tr>
			<td colspan='2' align='center'>Update Address</td>
		</tr>

		<tr>
			<td>Address 1</td>
			<td><input type='text' name='Address1'
				value='<%=user.getAddress().getLine_1()%>'></td>
		</tr>
		<tr>
			<td>Address 2</td>
			<td><input type='text' name='Address2'
				value='<%=user.getAddress().getLine_2()%>'></td>
		</tr>
		<tr>
			<td>Street(area)</td>
			<td><input type='text' name='Street'
				value='<%=user.getAddress().getStreet()%>'></td>
		</tr>
		<tr>
			<td>City</td>
			<td><input type='text' name='City'
				value='<%=user.getAddress().getCity()%>'></td>
		</tr>
		<tr>
			<td>State</td>
			<td><input type='text' name='State'
				value='<%=user.getAddress().getState()%>'></td>
		</tr>
		<tr>
			<td>Pincode</td>
			<td><input type='text' name='Pincode'
				value='<%=user.getAddress().getPincode()%>'></td>
		</tr>
		<tr>
			<td align='center' colspan='2'><input type='button' value='Next'
				onClick="javascript: submitForm('update.do?method=review');">
				&nbsp; &nbsp;</td>
		</tr>
	</table>
</html:form>