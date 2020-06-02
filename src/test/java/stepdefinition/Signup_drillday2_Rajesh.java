package stepdefinition;

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

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Signup_drillday2_Rajesh {
	
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://elastic.rapidtestpro.com:2777/Vayu1";

	static final String USER = "belitypi";
	static final String PASSWORD = "47GWrkhPknA3";
	public static String baseurl = "http://elastic.rapidtestpro.com:8086/index";
	public static String first_name, last_name, phone, email, username, password;
	WebDriver driver;
	LinkedList<String> gnames = new LinkedList<String>();
	
	@Given("^Open bank application and click on signup button_Rajesh$")
	public void open_bank_application_and_click_on_signup_button_Rajesh(){
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(baseurl);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^User enters the personal details and click on register button$")
	public void user_enters_the_personal_details_and_click_on_register_button() throws ClassNotFoundException, SQLException  {
		
		Connection connection = null;
		Statement statement = null;	
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
		statement = connection.createStatement();
		String query = "SELECT * FROM Rajesh_Sign_Up;";
		ResultSet results = statement.executeQuery(query);
		
		while (results.next()) {
			driver.findElement(By.xpath("//a[@class='btn btn-info btn-lg btn-block login-button']")).click(); 
			first_name = results.getString("firstName");
			driver.findElement(By.id("firstName")).sendKeys(first_name);
			last_name = results.getString("lastName");
			driver.findElement(By.id("lastName")).sendKeys(last_name);
			phone = results.getString("phone");
			driver.findElement(By.id("phone")).sendKeys(phone);
			email = results.getString("email");
			driver.findElement(By.id("email")).sendKeys(email);
			username = results.getString("userName");
			driver.findElement(By.id("username")).sendKeys(username);
			password = results.getString("passWord");
			driver.findElement(By.id("password")).sendKeys(password);
			driver.findElement(By.xpath("//button[@class='btn btn-primary btn-lg btn-block login-button']")).click();
			
			String query1 = "UPDATE Login INNER JOIN Rajesh_Sign_Up"
					+ "SET Login.username = Rajesh_Sign_Up.userName And Login.password = Rajesh_Sign_Up.passWord;";
			PreparedStatement preparedstmt = connection.prepareStatement(query1);
			preparedstmt.executeUpdate();
		}	
		
		
		
		results.close();
		statement.close();
		connection.close();
	}


	@Then("^User registration will be successful$")
	public void user_registration_will_be_successful() {
		System.out.println("Sign Up is Successful");
		driver.quit();
	    
	}


}
