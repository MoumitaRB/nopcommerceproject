package com.nopcommerce.utilities;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public  class DataBaseUtils {
	
	public static  ArrayList<Object[]>mydata;

	public static ArrayList<Object[]> populateData() throws SQLException
	{
	        mydata=new ArrayList<Object[]>();
	        
	       
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","root");
		    Statement stmt=  conn.createStatement();
		    String str="Select Email_id, Pass_word, Exp_result from ecommercelogindata;";
		    ResultSet rs= stmt.executeQuery(str);
	        
		    while(rs.next())
		    {
		      String emailid=rs.getString("Email_id");
		      String pwd=rs.getString("Pass_word");
		      String exp_res=rs.getString("Exp_result");
		      
		      Object obj[]= {emailid,pwd,exp_res};
		      mydata.add(obj);
		      
		    }
		    conn.close();
		    
		    for(Object[]x:mydata)
		    {
		    	for(Object y:x)
		    	{
		    		System.out.print(y+"   ");
		    	}
		    	System.out.println();
		    }
		    
           return mydata;
		
	   }
	

	
	}


