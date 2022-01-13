package com.abhi.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class StoredProcedureExample {
	
	static String url = "jdbc:mysql://localhost:9999/simplilearn";
    static String user = "root";
    static String password = "Abhinav.1";
    static String sql = "{call PRODUCT_PROC1(?,?,?)}";
    
	private static Connection con;
	
   public static void main(String[] args) {
      
      try {
    	  
    	  //STEP 2: Register JDBC driver
	      try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	      //STEP 3: Open a connection
	      System.out.println("Connecting to database...");
	      con = DriverManager.getConnection(url, user, password);
	      
	      CallableStatement stmt=con.prepareCall(sql);
         
         //Set IN parameter
         stmt.setInt(1, 1);  
         
         //Set OUT parameter
         stmt.registerOutParameter(2, Types.VARCHAR);
         
         //Set INOUT parameter
         stmt.setDouble(3, 24.10);
         stmt.registerOutParameter(3, Types.DOUBLE);
         
         //Execute stored procedure
         stmt.execute();
         
         // Get Out and InOut parameters
         System.out.println("Product Name = "+stmt.getString(2));
         System.out.println("Product Old Price = "+stmt.getDouble(3));
         
      } catch (SQLException e) {
         e.printStackTrace();
         e.getErrorCode();
      }
   }
}