 package com.rs.fer.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.rs.fer.bean.Address;
import com.rs.fer.bean.Expense;
import com.rs.fer.bean.User;
import com.rs.fer.util.DBUtil;

public class FERServiceImpl implements FERService {
	final static Logger logger = Logger.getLogger(FERServiceImpl.class);
	@Override
	public boolean registeration(User user) {

		boolean isRegister = false;

		Connection connection = null;
		PreparedStatement statement = null;

		try {

			connection = DBUtil.getConnection();

			String inputSQL = "insert into user(first_name, middle_name, last_name,email, username, password, mobile_number) values(?, ?,?, ?,?, ?, ?)";
			statement = connection.prepareStatement(inputSQL);

			statement.setString(1, user.getFirst_name());
			statement.setString(2, user.getMiddle_name());
			statement.setString(3, user.getLast_name());

			statement.setString(4, user.getEmail());
			statement.setString(5, user.getUsername());
			statement.setString(6, user.getPassword());
			statement.setString(7, user.getMobile_number());

			int numOfRecAffected = statement.executeUpdate();
			System.out.println("numOfRecAffected:" + numOfRecAffected);

			isRegister = numOfRecAffected > 0;

		}

		catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(connection);
		}

		return isRegister;
	}

	@Override
	public int login(String username, String password) {

		int id = 0;

		Connection connection = null;
		PreparedStatement statement = null;

		try {
			connection = DBUtil.getConnection();
			statement = connection.prepareStatement("SELECT * FROM USER WHERE username=? AND PASSWORD=?");
			statement.setString(1, username);
			statement.setString(2, password);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				id = resultSet.getInt("id");
				System.out.println("Match found....");
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		} finally {
			DBUtil.closeConnection(connection);
		}

		return id;
	}

	@Override
	public boolean addExpense(Expense expense) {

		boolean isAddExpense = false;

		Connection connection = null;
		PreparedStatement statement = null;

		try {

			connection = DBUtil.getConnection();

			statement = connection.prepareStatement(
					"insert into expense(expense_type,date,price,no_of_items,total,by_whom,userid) values(?,?,?,?,?,?,?)");

			statement.setString(1, expense.getExpense_type());
			statement.setString(2, expense.getDate());
			statement.setFloat(3, expense.getPrice());
			statement.setInt(4, expense.getNo_of_items());
			statement.setFloat(5, expense.getTotal());
			statement.setString(6, expense.getBy_whom());
			statement.setInt(7, expense.getUserid());

			int numOfRecAffected = statement.executeUpdate();
			System.out.println("numOfRecAffected:" + numOfRecAffected);

			isAddExpense = numOfRecAffected > 0;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(connection);
		}
		return isAddExpense;

	}

	@Override
	public boolean editExpense(Expense expense) {

		boolean isEditExpense = false;

		Connection connection = null;
		PreparedStatement statement = null;

		try {

			connection = DBUtil.getConnection();

			statement = connection.prepareStatement(
					"update expense set expense_type=?, date=?, price=?, no_of_items=? ,total=? ,by_whom=? where id=?");
			statement.setString(1, expense.getExpense_type());
			statement.setString(2, expense.getDate());
			statement.setFloat(3, expense.getPrice());
			statement.setInt(4, expense.getNo_of_items());
			statement.setFloat(5, expense.getTotal());
			statement.setString(6, expense.getBy_whom());
			statement.setInt(7, expense.getId());

			int numOfRecAffected = statement.executeUpdate();
			System.out.println("numOfRecAffected:" + numOfRecAffected);

			isEditExpense = numOfRecAffected > 0;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(connection);
		}
		return isEditExpense;

	}

	@Override
	public boolean deleteExpense(int expenseId) {

		boolean isDeleteExpense = false;
		Connection connection = null;
		PreparedStatement statement = null;

		try {

			connection = DBUtil.getConnection();

			statement = connection.prepareStatement("delete from expense where id=? ");

			statement.setInt(1, expenseId);

			int numOfRecAffected = statement.executeUpdate();

			System.out.println("numOfRecAffected:" + numOfRecAffected);

			isDeleteExpense = numOfRecAffected > 0;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(connection);
		}
		return isDeleteExpense;
	}

	@Override
	public boolean resetPassword(int id, String currentPassword, String newPassword) {

		boolean isReset = false;

		Connection connection = null;
		PreparedStatement statement = null;

		try {

			connection = DBUtil.getConnection();

			statement = connection.prepareStatement("update user set password=? where id=? and password=?");
			statement.setString(1, newPassword);
			statement.setInt(2, id);
			statement.setString(3, currentPassword);

			int reset = statement.executeUpdate();
			System.out.println("numOfRecAffected:" + reset);

			isReset = reset > 0;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(connection);
		}
		return isReset;
	}

	@Override
	public List<Expense> getExpenses(int userid) {

		Connection connection = null;
		PreparedStatement statement = null;
		List<Expense> expenses = new ArrayList<Expense>();

		try {

			connection = DBUtil.getConnection();

			statement = connection.prepareStatement("select * from expense where userid=?");

			statement.setInt(1, userid);
			ResultSet ge = statement.executeQuery();
			Expense expense = null;

			while (ge.next()) {

				expense = new Expense();
				expense.setId(ge.getInt("id"));
				expense.setExpense_type(ge.getString("expense_type"));
				expense.setDate(ge.getString("date"));
				expense.setPrice(ge.getFloat("price"));
				expense.setNo_of_items(ge.getInt("no_of_items"));
				expense.setTotal(ge.getFloat("total"));
				expense.setBy_whom(ge.getString("by_whom"));
				expense.setUserid(ge.getInt("userid"));

				expenses.add(expense);
				System.out.println(ge.getString("expense_type") + "," + ge.getString("date") + ","
						+ ge.getFloat("price") + "," + ge.getInt("no_of_items") + "," + ge.getFloat("total") + ","
						+ ge.getString("by_whom") + "," + ge.getInt("userid"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(connection);
		}
		return expenses;

	}

	@Override
	public Expense getExpense(int id) {

		Connection connection = null;
		PreparedStatement statement = null;
		Expense expense = new Expense();

		try {

			connection = DBUtil.getConnection();

			statement = connection.prepareStatement("select * from expense where id=?");

			statement.setInt(1, id);
			ResultSet ge = statement.executeQuery();

			while (ge.next()) {

				expense = new Expense();
				expense.setId(ge.getInt("id"));
				expense.setExpense_type(ge.getString("expense_type"));
				expense.setDate(ge.getString("date"));
				expense.setPrice(ge.getFloat("price"));
				expense.setNo_of_items(ge.getInt("no_of_items"));
				expense.setTotal(ge.getFloat("total"));
				expense.setBy_whom(ge.getString("by_whom"));
				expense.setUserid(ge.getInt("userid"));

				System.out.println(ge.getInt("id") + "," + ge.getString("expense_type") + "," + ge.getString("date")
						+ "," + ge.getFloat("price") + "," + ge.getInt("no_of_items") + "," + ge.getFloat("total") + ","
						+ ge.getString("by_whom") + "," + ge.getInt("userid"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(connection);
		}
		return expense;

	}

	@Override
	public List<Expense> expenseReport(String expense_type, String fromDate, String toDate) {

		Connection connection = null;
		PreparedStatement statement = null;
		List<Expense> expenseReport = new ArrayList<Expense>();

		try {

			connection = DBUtil.getConnection();

			statement = connection
					.prepareStatement("select * from expense where expense_type=? and date between ? and ?");

			statement.setString(1, expense_type);
			statement.setString(2, fromDate);
			statement.setString(3, toDate);

			ResultSet ge = statement.executeQuery();

			Expense expense = null;

			while (ge.next()) {
				expense = new Expense();
				
				expense.setId(ge.getInt("id"));
				expense.setExpense_type(ge.getString("expense_type"));
				expense.setDate(ge.getString("date"));
				expense.setPrice(ge.getFloat("price"));
				expense.setNo_of_items(ge.getInt("no_of_items"));
				expense.setTotal(ge.getFloat("total"));
				expense.setBy_whom(ge.getString("by_whom"));
				expense.setId(ge.getInt("userid"));

				expenseReport.add(expense);
				System.out.println(ge.getInt("id") + "," + ge.getString("expense_type") + "," + ge.getString("date")
						+ "," + ge.getFloat("price") + "," + ge.getInt("no_of_items") + "," + ge.getFloat("total") + ","
						+ ge.getString("by_whom") + "," + ge.getInt("userid"));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(connection);
		}
		return expenseReport;
	}

	@Override
	public User getUser(int userid) {
		Connection connection = null;
		PreparedStatement statement = null;
		User user = new User();

		try {

			connection = DBUtil.getConnection();

			statement = connection.prepareStatement(
					"select u.*, a.* from user u left join address a on u.id=a.userid where u.id=?");
			statement.setInt(1, userid);
			ResultSet ge = statement.executeQuery();

			while (ge.next()) {

				user.setId(ge.getInt(1));
				user.setFirst_name(ge.getString(2));
				user.setMiddle_name(ge.getString(3));
				user.setLast_name(ge.getString(4));
				user.setEmail(ge.getString(5));
				user.setUsername(ge.getString(6));
				user.setPassword(ge.getString(7));
				user.setMobile_number(ge.getString(8));

				Address ad = new Address();
				
				
				ad.setLine_1(ge.getString(10));
				ad.setLine_2(ge.getString(11));
				ad.setStreet(ge.getString(12));
				ad.setCity(ge.getString(13));
				ad.setState(ge.getString(14));
				ad.setPincode(ge.getInt(15));
				ad.setCountry(ge.getString(16));
				ad.setUserid(ge.getInt(17));

				user.setAddress(ad);
				System.out.println(ge.getInt(1) + "," + ge.getString(2) + ","
						+ ge.getString(3) + "," +ge.getString(4) + "," + ge.getString(5)
						+ "," + ge.getString(6)+ "," + ge.getString(7) + "," + ge.getString(10)
						+ "," + ge.getString(11) + "," + ge.getString(12) + "," + ge.getString(13) + "," + ge.getString(14)+ ","
						+ ge.getInt(15) + "," + ge.getString(16) + "," + ge.getInt(17));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(connection);
		}
		return user;

	}

	@Override
	public boolean updateUser(User user) {
		Connection connection = null;
		PreparedStatement statement = null;
		int updateUser = 0;
		boolean isUpdate = false;

		try {

			connection = DBUtil.getConnection();

			String inputSQL = "update user set first_name=?, middle_name=?, last_name=?, email=?, username=?, password=?, mobile_number=? where id=?";
			statement = connection.prepareStatement(inputSQL);

			statement.setString(1, user.getFirst_name());
			statement.setString(2, user.getMiddle_name());
			statement.setString(3, user.getLast_name());

			statement.setString(4, user.getEmail());
			statement.setString(5, user.getUsername());
			statement.setString(6, user.getPassword());
			statement.setString(7, user.getMobile_number());
			statement.setInt(8, user.getId());

			int numOfRecAffected = statement.executeUpdate();
			System.out.println("numOfRecUpdated" + numOfRecAffected);

			Address ad = user.getAddress();

			String inputAddress = " ";
			if (numOfRecAffected > 0) {
				if (ad.getId() == 0) {
					inputAddress = "insert into address(line_1, line_2, street, city, state, pincode, country, userid) values(?,?,?,?,?,?,?,?)";
				} else {
					inputAddress = "update address set line_1=?, line_2,=?, street=?, city=?, state=?, pincode=?, country=? where userid=?";

				}
				statement = connection.prepareStatement(inputAddress);
				statement.setString(1, ad.getLine_1());
				statement.setString(2, ad.getLine_2());
				statement.setString(3, ad.getStreet());
				statement.setString(4, ad.getCity());
				statement.setString(5, ad.getState());
				statement.setInt(6, ad.getPincode());
				statement.setString(7, ad.getCountry());
				statement.setInt(8, ad.getUserid());

				int adR = statement.executeUpdate();
				System.out.println("Address record is update:" + adR);
				isUpdate = adR > 0;

				System.out.println(user.getFirst_name() + "," + user.getMiddle_name() + "," + user.getLast_name() + ","
						+ user.getEmail() + "," + user.getUsername() + "," + user.getPassword()
						+ user.getMobile_number() + "," + ad.getLine_1() + "," + ad.getLine_2() + "," + ad.getStreet()
						+ "," + ad.getCity() + "," + ad.getState() + "," + ad.getPincode() + "," + ad.getCountry() + ","
						+ ad.getUserid());

			}

		}

		catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(connection);
		}

		return isUpdate;
	}

}
