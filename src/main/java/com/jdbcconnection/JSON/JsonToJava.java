package com.jdbcconnection.JSON;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonToJava {

	public static void main(String args[]) throws ClassNotFoundException, SQLException, JsonGenerationException, JsonMappingException, IOException {
		Class.forName("com.mysql.cj.jdbc.Driver");  //this class.forName() is responsible to load the class dynamically in runtime 
        Connection conn =null;  // as of now no connection so it is null 
        conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/Business", "root", "root");   //This service enable after above class  and responsible to establish connection		
		//url is where our Mysql is sitting like location  and connection string details 
		ArrayList<CustomerDetails> al = new ArrayList<CustomerDetails>();
		
		//object of Statement class will help us to execute queries
	  Statement st = conn.createStatement();
	  ResultSet rs=st.executeQuery("select * from CustomerInfo where purchasedDate=CURDATE() and Location ='Asia';");
	   //rs has result like array 
	  while (rs.next()) {  //setting pointer to respective row like first row, second row etc.. and it values is true it will move inside  
	  
		  CustomerDetails cd = new CustomerDetails();  
			  
		  cd.setCoursename(rs.getString(1));
		  cd.setPurchasedate(rs.getString(2));
		  cd.setAmount(rs.getInt(3));
		  cd.setLocation(rs.getString(4));
		  al.add(cd);   //adding objects to array list 
		  
	  }
	  for(int i=0;i<al.size();i++) {
		  
		  ObjectMapper or = new ObjectMapper(); //This is the class in Jackson API used for creating Object for entire class 
			 // or.writeValue(Jsnon file location, from object which it has to pick);
	or.writeValue(new File("C:\\Bala\\EclipseEE\\Eclipse IDE for Enterprise Java Developers\\workspace\\JSON\\customerInfo"+i+".json"),al.get(i));
			   
		  
	  }
	  
		conn.close();
	}
	
	
}
