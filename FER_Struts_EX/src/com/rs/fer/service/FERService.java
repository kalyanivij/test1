package com.rs.fer.service;

import java.util.List;

import com.rs.fer.bean.Expense;
import com.rs.fer.bean.User;

public interface FERService {

	boolean registeration(User user);

	int login(String username, String password);

	boolean addExpense(Expense expense);

	boolean editExpense(Expense expense);

	boolean deleteExpense(int expenseId);

	boolean resetPassword(int id, String currentPassword, String newPassword);

	List<Expense> getExpenses(int id);

	Expense getExpense(int id);

	List<Expense> expenseReport( String expense_type, String fromDate, String toDate);

	User getUser(int userid);

	boolean updateUser(User user);

}
