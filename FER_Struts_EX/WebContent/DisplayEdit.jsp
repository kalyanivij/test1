<%@page import="com.rs.fer.bean.Expense"%>
<%@page import="java.util.List"%>
<%@taglib uri="WEB-INF/struts-html.tld" prefix="html"%>

<html:form action="editE">
<%
	List<Expense> expenses = (List<Expense>) session.getAttribute("expenses");
%>
SelectExpense:
<select name='expenseId'>
	<%
		if (expenses != null && !expenses.isEmpty()) {
			int value = 0;
			String desc = null;
			for (Expense expense : expenses) {
				value = expense.getId();
				desc = expense.getExpense_type() + ", " + expense.getDate() + ", " + expense.getTotal();
	%>
	<option value='<%=value%>'><%=desc%></option>
	<%
		}
		}
	%>
</select>
<br>
<br>
<input type='button' value='Edit'
	onClick="javascript:submitForm('editE.do?method=display');">
&nbsp; &nbsp;
</html:form>