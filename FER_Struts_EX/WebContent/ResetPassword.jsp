<%@taglib uri="WEB-INF/struts-html.tld" prefix="html"%>

<div style="color: red">
	<html:errors />
</div>
<html:form action="resetP">


	<table align="center" border="1" height="400px" width="250px">
		<tr>
			<td colspan='2' align="center">Reset Password</td>
		</tr>

		<tr>
			<td>id</td>
			<td><html:text name="ResetForm" property='id' /></td>
		</tr>
		<tr>
			<td>Current Password</td>
			<td><html:password name="ResetForm" property='currentPassword' /></td>
		</tr>
		<tr>
			<td>New Password</td>
			<td><html:password name="ResetForm" property='newPassword' /></td>
		</tr>
		<tr>
			<td>Confirm Password</td>
			<td><html:password name="ResetForm" property='confirmPassword' /></td>
		</tr>

		<tr>
			<td align='center' colspan='2'><input type='button'
				value='Submit'
				onClick="javascript: submitForm('resetP.do?method=reset');"></td>
		</tr>
	</table>
</html:form>