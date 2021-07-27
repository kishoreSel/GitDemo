package com.jdbcconnection.JSON;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ExtractJsontoObject {

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		// TODO Auto-generated method stub
		
		  ObjectMapper or = new ObjectMapper(); //This is the class in Jackson API used for creating Object for entire class 
			 // or.writeValue(Jsnon file location, from object which it has to pick);
		  CustomerDetailsTransactionName c = or.readValue(new File ("C:\\Bala\\EclipseEE\\Eclipse IDE for Enterprise Java Developers\\workspace\\JSON\\customerInfo.json"),CustomerDetailsTransactionName.class);
	      System.out.println(c.getAmount());
	  

	}

}
