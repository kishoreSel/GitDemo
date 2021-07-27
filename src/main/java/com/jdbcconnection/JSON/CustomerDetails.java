package com.jdbcconnection.JSON;

public class CustomerDetails {
	
	private String coursename;
	private String purchasedate;
	private int amount;
	private String location;
	
	//get and set methods, set method is assigning  the result value and get method is used to get values
	
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
