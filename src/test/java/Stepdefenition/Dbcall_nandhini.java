package Stepdefenition;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.mysql.cj.protocol.Resultset;

import io.github.bonigarcia.wdm.WebDriverManager;
 
public class Dbcall_nandhini {
	
	
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://elastic.rapidtestpro.com:2777/Vayu1";
//for php admin use the below link and the user credentials declared in USER & PASSWORD
//http://elastic.rapidtestpro.com:8065/sql.php?server=1&db=test&table=info&pos=0
    static final String USER = "belitypi";
    static final String PASSWORD = "47GWrkhPknA3";
       public static void dbcall(String date,String location,String notes) 
       {
       Connection conn = null;
       Statement stmt = null;
       
       try{
          //STEP 2: Register JDBC driver
           Class.forName("com.mysql.cj.jdbc.Driver");
          // String vDateYMD = dateFormatYMD.format(now);
          //STEP 3: Open a connection
          System.out.println("Connecting to a  database...");
          conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
          System.out.println("Connected database successfully...");
          
          String query = " Insert into nandhini_techfishbank (Datetime,Pickuplocation,Notes) values(?,?,?)";
         
          // create the mysql insert preparedstatement
          PreparedStatement preparedStmt = conn.prepareStatement(query);
          preparedStmt.setString(1,date);
          preparedStmt.setString(2,location);
          preparedStmt.setString(3, notes);
          // execute the preparedstatement
          preparedStmt.execute();
         
          conn.close();
			
       }catch(SQLException se){
          //Handle errors for JDBC
          se.printStackTrace();
       }catch(Exception e){
          //Handle errors for Class.forName
          e.printStackTrace();
       }finally{
          //finally block used to close resources
          try{
             if(stmt!=null)
                conn.close();
          }catch(SQLException se){
          }// do nothing
          try{
             if(conn!=null)
                conn.close();
          }catch(SQLException se){
             se.printStackTrace();
          }//end finally try
       }//end try
       System.out.println("values added sucessfully!");
      
    }
       //end main
	//private static void calldb() {
	//	main();
       
	//}s
	
    }//end JDBCExample
  

