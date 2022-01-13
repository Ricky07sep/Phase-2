package com.abhi.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JdbcConnectionTest {

	private static final String url = "jdbc:mysql://localhost:9999/simplilearn";
	private static final String user = "root";
	private static final String password = "Abhinav.1";
	private static Connection con;
	private static Statement stmt;
	private static ResultSet rs;

	public static void main(String[] args) {
		JdbcConnectionTest obj = new JdbcConnectionTest();
		Scanner sc = new Scanner(System.in);
		System.out.println("=========Menu=============");
		System.out.println("1. Retrive the employee data");
		System.out.println("2. Count number of employee");
		System.out.println("3. Insert a new Employee record");
		System.out.println("4. Update the employee record");
		System.out.println("1================================");
		System.out.println("Enter your choice from (1-4) : ");

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
		default:
			break;
		}
	}

	public void retriveData() {
		String query1 = "select empid,empname,salary from emp";
		try {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException ex) {
				ex.printStackTrace();
			}
			con = DriverManager.getConnection(url, user, password);
			stmt = con.createStatement();
			rs = stmt.executeQuery(query1);

			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				int salary = rs.getInt(3);
				System.out.println("EmpID : " + id + " EmpName : " + name + " Salary : " + salary);
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
		String query3 = "insert into simplilearn.emp(empid,empname,salary) \n" + "values(108, 'Abhishek', 45000)";
		try {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException ex) {
				ex.printStackTrace();
			}
			con = DriverManager.getConnection(url, user, password);
			stmt = con.createStatement();
			int v = stmt.executeUpdate(query3);

			if (v == 1) {
				System.out.println("Record is inserted");
			} else {
				System.out.println("Record is Not inserted");
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
		String query4 = "update simplilearn.emp set salary = 55000 where empid in (102)";
		try {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException ex) {
				ex.printStackTrace();
			}
			con = DriverManager.getConnection(url, user, password);
			stmt = con.createStatement();
			int v = stmt.executeUpdate(query4);
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
