<%@taglib uri="WEB-INF/struts-html.tld" prefix="html"%>

<%@page import="com.rs.fer.bean.Expense"%>
<%@page import="java.util.List"%>
<%@page import="com.rs.fer.service.FERServiceImpl"%>
<%@page import="com.rs.fer.service.FERService"%>
<html:form action="expense">
<table align='center' border='1' height='75px width='
	50px' cellpadding='1px'>
	<tr>
		<th>Expense Type</th>
		<th>Date</th>
		<th>Price</th>
		<th>No. Of Items</th>
		<th>Total</th>
		<th>Action</th>
	</tr>
	<%
		List<Expense> expenses = (List<Expense>) session.getAttribute("expenses");
	
		for (Expense expense : expenses) {
	%>
	<tr>
		<td><input type='text' name='expenseType'
			value='<%=expense.getExpense_type()%>'></td>
		<td><input type='date' name='date' value='<%=expense.getDate()%>'></td>
		<td><input type='number' name='price'
			value='<%=expense.getPrice()%>'></td>
		<td><input type='number' name='noOfItems'
			value='<%=expense.getNo_of_items()%>'></td>
		<td><input type='number' name='total'
			value='<%=expense.getTotal()%>'></td>
		<td><input type='text' name='byWhom'
			value='<%=expense.getBy_whom()%>'></td>
	</tr>
	<%
		}
	%>
</table>
</html:form>
