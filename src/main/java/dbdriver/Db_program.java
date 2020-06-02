package dbdriver;

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

import io.github.bonigarcia.wdm.WebDriverManager;

public class Db_program {

//JDBC Connection Driver with MYSQL Docker URL
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://elastic.rapidtestpro.com:2777/Vayu1";

//for php admin use the below link and the user credentials declared in USER & PASSWORD
//http://elastic.rapidtestpro.com:8065/sql.php?server=1&db=test&table=info&pos=0

	static final String USER = "belitypi";
	static final String PASSWORD = "47GWrkhPknA3";

	public static LinkedList<String> names = new LinkedList<String>();

	public static LinkedList<String> getFromDB() throws ClassNotFoundException, SQLException, InterruptedException {
		Connection connection = null;
		Statement statement = null;

		Class.forName("com.mysql.cj.jdbc.Driver");
		connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);

		statement = connection.createStatement();

		String query = "SELECT * FROM nandhininew ;";

		ResultSet results = statement.executeQuery(query);

		while (results.next()) {

			names.add(results.getString("empName"));

			System.out.print(results.getString("empname"));
			System.out.print("    ");
			System.out.print(results.getInt("empid"));
			System.out.print("  ");
			System.out.print(results.getString("username"));
			System.out.print("  ");
			System.out.print(results.getString("password"));
			System.out.print("");
			System.out.print(results.getString("valid/invalid"));
			System.out.print("");
			System.out.println();
			WebDriver driver;
			WebDriverManager.chromedriver().setup();

			driver = new ChromeDriver();
			driver.get("https://github.com/session");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//input[@id='login_field']")).sendKeys(results.getString("username"));
			driver.findElement(By.xpath("//input[@id='password']")).sendKeys(results.getString("password"));
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@name='commit']")).click();
			if (driver.findElement(By.xpath("//div[@class='container-lg px-2']")).isDisplayed()) {
				String query1 = "UPDATE nandhininew SET valid/invalid = 'invalid' where username="
						+ results.getString("username");
				System.out.println(query1);
				PreparedStatement preparedstmt = connection.prepareStatement(query1);
				preparedstmt.executeUpdate();

			} else {
				String query1 = "UPDATE nandhininew SET valid/invalid = 'valid' where username="
						+ results.getString("username");
				System.out.println(query1);
				PreparedStatement preparedstmt = connection.prepareStatement(query1);
				preparedstmt.executeUpdate();

			}
		}
		results.close();
		statement.close();
		connection.close();
		return names;
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException, InterruptedException {

		LinkedList<String> gnames = new LinkedList<String>();
		gnames = getFromDB();

		System.out.println("   ");
		for (String name : gnames) {
			System.out.print(name);
			System.out.print(" ");

		}

	}
}
