<%@taglib uri="WEB-INF/struts-html.tld" prefix="html"%>

<style>
* {
	box-sizing: border-box;
}

title {
	padding-top: 50px;
}

body {
	background-color: white;
	padding-top: 50px;
	text-color: purple;
}
</style>
<div style="color: red">
	<html:errors />
</div>

<html:form action="addE">
	<table align="center" border="1" height="400px" width="250px">
		<tr>
			<td colspan='2' align="center">Add Expense</td>
		</tr>

		<tr>
			<td>Expense Type</td>
			<td><html:text name="ExpenseForm" property='expenseType' /></td>
		</tr>
		<tr>
			<td>Date</td>
			<td><html:text name="ExpenseForm" property='date' /></td>
		</tr>
		<tr>
			<td>Price</td>
			<td><html:text name="ExpenseForm" property='price' /></td>
		</tr>
		<tr>
			<td>No. Of Items</td>
			<td><html:text name="ExpenseForm" property='noOfItems' /></td>
		</tr>
		<tr>
			<td>Total</td>
			<td><html:text name="ExpenseForm" property='total' /></td>
		</tr>
		<tr>
			<td>By Whom</td>
			<td><html:text name="ExpenseForm" property='byWhom' /></td>
		</tr>
		<tr>
			<td align='center' colspan='2'><input type="button"
				value='Save Expense' onClick="javascript: submitForm('addE.do?method=add');"></td>
		</tr>
	</table>
</html:form>
