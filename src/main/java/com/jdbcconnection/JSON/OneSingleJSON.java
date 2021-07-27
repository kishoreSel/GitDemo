package com.jdbcconnection.JSON;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.commons.lang3.StringEscapeUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;



public class OneSingleJSON {

	public static void main(String args[]) throws ClassNotFoundException, SQLException, JsonGenerationException, JsonMappingException, IOException {
		Class.forName("com.mysql.cj.jdbc.Driver");  //this class.forName() is responsible to load the class dynamically in runtime 
        Connection conn =null;  // as of now no connection so it is null 
        ArrayList<CustomerDetails> al = new ArrayList<CustomerDetails>();
        
		conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/Business", "root", "root");   //This service enable after above class  and responsible to establish connection		
		//url is where our Mysql is sitting like location  and connection string details 
		JSONArray ja = new JSONArray();
		
		//object of Statement class will help us to execute queries
	  Statement st = conn.createStatement();
	  ResultSet rs=st.executeQuery("select * from CustomerInfo where Location ='Asia';");
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
	  
	  //Create Json string from Java object for this we need gson dependency
	  Gson g = new Gson();
	  String jsonString = g.toJson(al.get(i));	 //Java object is sending as argument to Json string    
	  ja.add(jsonString);
	  }
	  //Jackson won't create multiple files in a single JSON
	  //JSON dynamically or aggregate all JSON's  need JSON simple dependency 
	  //JsonSiple
	  JSONObject jo = new JSONObject();    //need to create main JSON object i.e data and values are nested JSON Array 
	  jo.put("data", ja);    // data : values are the arguments here. Values will come from belwo JSONArray class 
	 // System.out.println(jo.toJSONString());  //it will print the strings not objects 
	 String unescape =  StringEscapeUtils.unescapeJava(jo.toJSONString());
	  //System.out.println(unescape);   //it will use to unescape the characters in string 
	  String str1 = unescape.replace("\"{", "{");
	  String finalString = str1.replace("}\",", "},");
	  System.out.println(finalString);
	  
	  //to writ e the final string into one single file
	  try(FileWriter file = new FileWriter("C:\\Bala\\EclipseEE\\Eclipse IDE for Enterprise Java Developers\\workspace\\JSON\\SingleJson.json")) {
		  file.write(finalString);
	  }   
	  
		conn.close();
	}
	
	
}
