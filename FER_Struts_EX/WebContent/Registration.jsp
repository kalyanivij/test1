<%@taglib uri="WEB-INF/struts-html.tld" prefix="html"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style>
* {
	box-sizing: border-box;
}

body {
	background-color: white;
	text-color: purple;
}
</style>
<div style="color: red">
	<html:errors />
</div>
<title>Registration</title>

</head>
<body>
	<header align='center'>
		<p>
			<font size='15'>Create a New Account</font>
		</p>
		<p>
			<font size='5'>It's quick and easy</font>
	</header>
	<html:form  action="/register">
		<html:img src="register.jpg.jpg" width="800" height="400"
			alt="lets save money" />
		<table align="right" border="1" height="400px" width="300px">
			<tr>
				<td colspan='2' align="center">Registration</td>
			</tr>

			<tr>
				<td>First Name</td>
				<td><html:text name="RegistrationForm" property="firstName"/><br></td>
			</tr>
			<tr>
				<td>Middle Name</td>
				<td><html:text name="RegistrationForm" property='middleName'/><br></td>
			</tr>
			<tr>
				<td>Last Name</td>
				<td><html:text name="RegistrationForm" property='lastName'/><br></td>
			</tr>
			<tr>
				<td>EmailId</td>
				<td><html:text name="RegistrationForm" property='emailId'/><br></td>
			</tr>
			<tr>
				<td>User Name</td>
				<td><html:text name="RegistrationForm" property='username'/><br></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><html:password name="RegistrationForm" property='password'/><br></td>
			</tr>
			<tr>
				<td>Mobile Number</td>
		
				<td><html:text name="RegistrationForm" property='mobileNumber'/><br></td>
			</tr>
			<tr>
				<td align='center' colspan='2'><input type="submit"
					value='Register'><br></td>
			</tr>
		</table>
	</html:form>

</body>
</html>