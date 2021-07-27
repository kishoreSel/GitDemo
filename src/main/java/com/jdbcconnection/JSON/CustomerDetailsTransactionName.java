package com.jdbcconnection.JSON;

public class CustomerDetailsTransactionName {
	
	private String coursename;
	private String purchasedate;
	private int amount;
	private String location;
	private int Transaction;
	
	//get and set methods, set method is assigning  the resut value and get method is used to get values
	
	public int getTransaction() {
		return Transaction;
	}
	public void setTransaction(int transaction) {
		Transaction = transaction;
	}
	public String getCoursename() {
		return coursename;
	}
	public void setCoursename(String coursename) {   //it will use to assign DB results value to this variable 
		this.coursename = coursename;
	}
	public String getPurchasedate() {
		return purchasedate;
	}
	public void setPurchasedate(String purchasedate) {
		this.purchasedate = purchasedate;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	

}
