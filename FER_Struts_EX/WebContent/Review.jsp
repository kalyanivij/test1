<%@page import="com.rs.fer.service.FERServiceImpl"%>
<%@page import="com.rs.fer.service.FERService"%>
<%@page import="com.rs.fer.bean.User"%>
<%@taglib uri="WEB-INF/struts-html.tld" prefix="html"%>
<%
	session = request.getSession();
	int id = Integer.parseInt(session.getAttribute("id").toString());

	User user = (User) session.getAttribute("user");
%>
<html:form action="update">
	<table align='center' border='1' height='400px' width='250px'>
		<tr>
			<td colspan='2' align='center'>Review</td>
		</tr>
		<tr>
			<td>First Name</td>
			<td><%=user.getFirst_name()%></td>
		</tr>
		<tr>
			<td>Middle Name</td>
			<td><%=user.getMiddle_name()%></td>
		</tr>
		<tr>
			<td>Last Name</td>
			<td><%=user.getLast_name()%></td>
		</tr>
		<tr>
			<td>Email Id</td>
			<td><%=user.getEmail()%></td>
		</tr>
		<tr>
			<td>Mobile Number</td>
			<td><%=user.getMobile_number()%></td>
		</tr>
		<tr>
			<td>Address 1</td>
			<td><%=user.getAddress().getLine_1()%></td>
		</tr>
		<tr>
			<td>Address 2</td>
			<td><%=user.getAddress().getLine_2()%></td>
		</tr>
		<tr>
			<td>Street(area)</td>
			<td><%=user.getAddress().getStreet()%></td>
		</tr>
		<tr>
			<td>City</td>
			<td><%=user.getAddress().getCity()%></td>
		</tr>
		<tr>
			<td>State</td>
			<td><%=user.getAddress().getState()%></td>
		</tr>
		<tr>
			<td>Pincode</td>
			<td><%=user.getAddress().getPincode()%></td>
		</tr>

		<tr>
			<td align='center' colspan='2'><input type='button' value='Next'
				onClick="javascript: submitForm('update.do?method=status');">
				&nbsp; &nbsp;</td>
		</tr>
	</table>
</html:form>
