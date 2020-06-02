package com.helper;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
public class Mysqldata {
	//JDBC Connection Driver with MYSQL Docker URL
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://elastic.rapidtestpro.com:2777/Vayu1";

//for php admin use the below link and the user credentials declared in USER & PASSWORD
//http://elastic.rapidtestpro.com:8065/sql.php?server=1&db=test&table=info&pos=0

    static final String USER = "belitypi";
    static final String PASSWORD = "47GWrkhPknA3";
    public static ArrayList<String> names = new ArrayList<String>();
    public static ArrayList<String> getFromDB() throws ClassNotFoundException, SQLException, InterruptedException {
        Connection connection = null;
        Statement statement = null;
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        statement = connection.createStatement();
        String query = "SELECT * FROM Nisha_table1;";
        ResultSet results = statement.executeQuery(query);
    
        while (results.next()) 
        {
        names.add(results.getString("Sort Entries"));
        names.add(results.getString("Search"));
        names.add(results.getString("Username"));
        names.add(results.getString("Password"));
            
           
            
             
        }
        results.close();
        statement.close();
        connection.close();
        return names;
    }
}
