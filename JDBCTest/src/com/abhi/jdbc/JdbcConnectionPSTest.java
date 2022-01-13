package com.abhi.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JdbcConnectionPSTest {

	private static final String url = "jdbc:mysql://localhost:9999/simplilearn";
	private static final String user = "root";
	private static final String password = "Abhinav.1";
	private static Connection con;
	private static Statement stmt;
	private static PreparedStatement pstmt;
	private static ResultSet rs;

	public static void main(String[] args) {
		JdbcConnectionPSTest obj = new JdbcConnectionPSTest();
		Scanner sc = new Scanner(System.in);
		System.out.println("=========Menu=============");
		System.out.println("1. Retrive the employee data");
		System.out.println("2. Count number of employee");
		System.out.println("3. Insert a new Employee record");
		System.out.println("4. Update the employee record");
		System.out.println("5. Delete the employee record");
		System.out.println("1================================");
		System.out.println("Enter your choice from (1-5) : ");

		int number = sc.nextInt();
		System.out.println("Your entered option : " + number);

		switch (number) {
		case 1:
			obj.retriveData();
			break;
		case 2:
			obj.countEmployees();
			break;
		case 3:
			obj.insertRecord();
			break;
		case 4:
			obj.updateRecord();
			break;
		case 5:
			obj.deleteRecord();
			break;
		default:
			break;
		}
	}

	public void retriveData() {
		try {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException ex) {
				ex.printStackTrace();
			}
			con = DriverManager.getConnection(url, user, password);
			stmt = con.createStatement();
			String query = "select * from emp";
			rs = stmt.executeQuery(query);
			System.out.println("ID Name Salary");

			while(rs.next()) {
				int id = rs.getInt("empid");
				String name1 = rs.getString("empname");
				int sal = rs.getInt("salary");
				System.out.println(id+" "+name1+" "+sal);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException ex) {

			}
			try {
				stmt.close();
			} catch (SQLException ex) {

			}
			try {
				rs.close();
			} catch (SQLException ex) {

			}
		}
	}

	public void countEmployees() {
		String query2 = "select count(*) from emp";
		try {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException ex) {
				ex.printStackTrace();
			}
			con = DriverManager.getConnection(url, user, password);
			stmt = con.createStatement();
			rs = stmt.executeQuery(query2);

			while (rs.next()) {
				int count = rs.getInt(1);
				System.out.println("Total number of Employee is : " + count);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException ex) {

			}
			try {
				stmt.close();
			} catch (SQLException ex) {

			}
			try {
				rs.close();
			} catch (SQLException ex) {

			}
		}
	}

	public void insertRecord() {
		String query3 = "insert into emp(empid,empname,salary) values(?,?,?)";
		try {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException ex) {
				ex.printStackTrace();
			}
			con = DriverManager.getConnection(url, user, password);
			pstmt = con.prepareStatement(query3);
			Scanner sc= new Scanner(System.in);
			System.out.println("Enter the empid : ");
			int eid = sc.nextInt();
			System.out.println("Enter empname : ");
			String name = sc.next();
			System.out.println("Enter the salary : ");
			int salary = sc.nextInt();
			
			pstmt.setInt(1, eid);
			pstmt.setString(2, name);
			pstmt.setInt(3, salary);
			
			int count = pstmt.executeUpdate();
			
			stmt = con.createStatement();
			String query = "select * from emp";
			rs = stmt.executeQuery(query);
			System.out.println("ID Name Salary");

			while(rs.next()) {
				int id = rs.getInt("empid");
				String name1 = rs.getString("empname");
				int sal = rs.getInt("salary");
				System.out.println(id+" "+name1+" "+sal);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException ex) {

			}
			try {
				stmt.close();
			} catch (SQLException ex) {

			}
		}
	}

	public void updateRecord() {
		String query4 = "update emp set salary = ? where empid = ?";
		try {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException ex) {
				ex.printStackTrace();
			}
			con = DriverManager.getConnection(url, user, password);
			pstmt = con.prepareStatement(query4);
			
			Scanner sc= new Scanner(System.in);
			System.out.println("Enter the empid : ");
			int eid = sc.nextInt();
			System.out.println("Enter the salary : ");
			int salary = sc.nextInt();
			
			pstmt.setInt(1, salary);
			pstmt.setInt(2, eid);
			
			int count = pstmt.executeUpdate();
			
			stmt = con.createStatement();
			String query = "select * from emp";
			rs = stmt.executeQuery(query);
			System.out.println("ID Name Salary");

			while(rs.next()) {
				int id = rs.getInt("empid");
				String name1 = rs.getString("empname");
				int sal = rs.getInt("salary");
				System.out.println(id+" "+name1+" "+sal);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException ex) {

			}
			try {
				stmt.close();
			} catch (SQLException ex) {

			}
		}
	}
	
	public void deleteRecord() {
		String query4 = "delete from emp where empid = ?";
		try {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException ex) {
				ex.printStackTrace();
			}
			con = DriverManager.getConnection(url, user, password);
			pstmt = con.prepareStatement(query4);
			
			Scanner sc= new Scanner(System.in);
			System.out.println("Enter the empid : ");
			int eid = sc.nextInt();
			
			pstmt.setInt(1, eid);
			
			int count = pstmt.executeUpdate();
			
			System.out.println("Record deleted successfully");
			
			stmt = con.createStatement();
			String query = "select * from emp";
			rs = stmt.executeQuery(query);
			System.out.println("ID Name Salary");

			while(rs.next()) {
				int id = rs.getInt("empid");
				String name1 = rs.getString("empname");
				int sal = rs.getInt("salary");
				System.out.println(id+" "+name1+" "+sal);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException ex) {

			}
			try {
				stmt.close();
			} catch (SQLException ex) {

			}
		}
	}
}
