<%@taglib uri="WEB-INF/struts-html.tld" prefix="html"%>

<div style="color: red">
	<html:errors />
</div>
<html:form action="expense">
<table align="center" border="1" height="400px" width="250px">
	<tr>
		<td colspan='2' align="center">Expense Report</td>
	</tr>
	
	<tr>
		<td>Expense Type</td>
		<td><input type="text" name='expenseType'></td>
	</tr>
	<tr>
		<td>From Date</td>
		<td><input type="date" name='fromDate'></td>
	</tr>
	<tr>
		<td>To Date</td>
		<td><input type="date" name='toDate'></td>
	</tr>

	<tr>
		<td align='center' colspan='2'><input type='button'
			value='Get Expense' onClick="javascript: submitForm('expense.do?method=report');"> &nbsp; &nbsp;</td>
	</tr>
</table>
</html:form>