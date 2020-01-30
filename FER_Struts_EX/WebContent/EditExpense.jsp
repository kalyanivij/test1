<%@taglib uri="WEB-INF/struts-html.tld" prefix="html"%>

<%@page import="com.rs.fer.bean.Expense"%>
<%@page import="com.rs.fer.service.FERServiceImpl"%>
<%@page import="com.rs.fer.service.FERService"%>

<html:form action="editE">

<%
	FERService ferservice = new FERServiceImpl();
	int expenseId = Integer.parseInt(request.getParameter("expenseId").toString());

	Expense expense = ferservice.getExpense(expenseId);
	session.setAttribute("expense", expense);
%>
<table align='center' border='1' height='400px' width='250px'>
	<tr>
		<td colspan='2' align='center'>Edit Expense</td>
	</tr>
	
	<tr>
		<td>Expense Type</td>
		<td><input type='text' name='expenseType'
			value='<%=expense.getExpense_type()%>'></td>
	</tr>
	<tr>
		<td>Date</td>
		<td><input type='text' name='date' value='<%=expense.getDate()%>'></td>
	</tr>
	<tr>
		<td>Price</td>
		<td><input type='number' name='price'
			value='<%=expense.getPrice()%>'></td>
	</tr>
	<tr>
		<td>No. Of Items</td>
		<td><input type='number' name='noOfItems'
			value='<%=expense.getNo_of_items()%>'></td>
	</tr>
	<tr>
		<td>Total</td>
		<td><input type='number' name='total'
			value='<%=expense.getTotal()%>'></td>
	</tr>
	<tr>
		<td>By Whom</td>
		<td><input type='text' name='byWhom'
			value='<%=expense.getBy_whom()%>'></td>
	</tr>

	<tr>
		<td align='center' colspan='2'><input type='button'
			value='Edit Expense' onClick="javascript: submitForm('editE.do?method=edit');"> &nbsp; &nbsp;</td>

	</tr>
</table>
</html:form>