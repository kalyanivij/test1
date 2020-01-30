package com.rs.fer.bean;

public class Expense {
	private int id;
	private String expense_type;
	private String date;
	private float price;
	private int no_of_items;
	private float total;
	private String by_whom;
	private int userid;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getExpense_type() {
		return expense_type;
	}

	public void setExpense_type(String expense_type) {
		this.expense_type = expense_type;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getNo_of_items() {
		return no_of_items;
	}

	public void setNo_of_items(int no_of_items) {
		this.no_of_items = no_of_items;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public String getBy_whom() {
		return by_whom;
	}

	public void setBy_whom(String by_whom) {
		this.by_whom = by_whom;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

}
