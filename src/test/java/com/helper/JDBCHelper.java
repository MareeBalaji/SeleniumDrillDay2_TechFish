package com.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

public class JDBCHelper {

	// JDBC Connection Driver with MYSQL Docker URL
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://elastic.rapidtestpro.com:2777/Vimal";

	// for php admin use the below link and the user credentials declared in
	// USER & PASSWORD
	// http://elastic.rapidtestpro.com:8065/sql.php?server=1&db=test&table=info&pos=0

	static final String USER = "belitypi";
	static final String PASSWORD = "47GWrkhPknA3";

	public static LinkedList<String> names = new LinkedList<String>();
	public static LinkedList<String> password = new LinkedList<String>();
	public static LinkedList<String> ammount = new LinkedList<String>();

	public LinkedList<String> getUserName() throws ClassNotFoundException, SQLException {
		Connection connection = null;
		Statement statement = null;

		Class.forName("com.mysql.cj.jdbc.Driver");
		connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);

		statement = connection.createStatement();

		String query = "SELECT * FROM FishBank ;";

		ResultSet results = statement.executeQuery(query);

		while (results.next()) {

			names.add(results.getString("Username"));
			System.out.println(results.getString("Username"));

		}

		results.close();
		statement.close();
		connection.close();

		return names;

	}

	public LinkedList<String> getPassword() throws ClassNotFoundException, SQLException {
		Connection connection = null;
		Statement statement = null;

		Class.forName("com.mysql.cj.jdbc.Driver");
		connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);

		statement = connection.createStatement();

		String query = "SELECT * FROM FishBank ;";

		ResultSet results = statement.executeQuery(query);

		while (results.next()) {

			password.add(results.getString("Password"));

		}

		results.close();
		statement.close();
		connection.close();

		return password;

	}
	
	public LinkedList<String> getAmount() throws ClassNotFoundException, SQLException {
		Connection connection = null;
		Statement statement = null;

		Class.forName("com.mysql.cj.jdbc.Driver");
		connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);

		statement = connection.createStatement();

		String query = "SELECT * FROM FishBank ;";

		ResultSet results = statement.executeQuery(query);

		while (results.next()) {

			ammount.add(results.getString("Amount"));

		}

		results.close();
		statement.close();
		connection.close();

		return ammount;

	}

}
