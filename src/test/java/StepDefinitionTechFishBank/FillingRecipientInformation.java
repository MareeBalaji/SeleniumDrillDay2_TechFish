package StepDefinitionTechFishBank;
import DbDriver.TechFishDb;

import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FillingRecipientInformation {
	static WebDriver driver;
	static final String DB_URL="jdbc:mysql://elastic.rapidtestpro.com:2777/Vayu1";
	static final String USER = "belitypi";
	static final String PASSWORD = "47GWrkhPknA3";
	//int i;
	
	@Given("User open the URL")
	public void user_open_the_URL() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://elastic.rapidtestpro.com:8086/index");
		driver.manage().window().maximize();
		// for the wait
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("varun1999");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Varun@1996");
		driver.findElement(By.xpath("//button[@class='btn btn-lg btn-primary btn-block']")).click();

		System.out.print("User opnes the application with URL");
		
	    
	}

	@When("User enters the username and password and add the Add Recipient")
	public void user_enters_the_username_and_password_and_add_the_Add_Recipient() throws ClassNotFoundException, SQLException {
		driver.findElement(By.xpath("//a[contains(text(),'Transfer')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Add')]")).click();
		
		Connection connection = null;
		Statement statement = null;

		Class.forName("com.mysql.cj.jdbc.Driver");
		connection = DriverManager.getConnection(DB_URL,USER,PASSWORD);

		statement = connection.createStatement();

		String query = "SELECT * FROM Varun ;";

		ResultSet results = statement.executeQuery(query);

		while(results.next()) {
			
			
			String Name = results.getString("name");
			driver.findElement(By.xpath("//input[@id='recipientName']")).sendKeys(Name);
			String Description = results.getString("description");
			driver.findElement(By.xpath("//textarea[@id='recipientDescription']")).sendKeys(Description);
			String Email = results.getString("emailId");
			driver.findElement(By.xpath("//input[@id='recipientEmail']")).sendKeys(Email);
			String Phonenumber = results.getString("phonenumber");
			driver.findElement(By.xpath("//input[@id='recipientPhone']")).sendKeys(Phonenumber);
			String Accnumber = results.getString("accnumber");
			driver.findElement(By.xpath("//input[@id='recipientAccountNumber']")).sendKeys(Accnumber);
			driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
			System.out.println("User enters the username and password and add the Add Recipient");
			
		}
			
	    		
				results.close();
				statement.close();
				connection.close();
				driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
				
		}
				
	

	@Then("Recipient Information successfully Created.")
	public void recipient_Information_successfully_Created() {
		System.out.println("Recipient Information successfully Created");
	    
	}
	
	@Given("user click on the particular recipient name")
	public void user_click_on_the_particular_recipient_name() {
		
		driver.findElement(By.linkText("Varun Mishra")).click();
		
		//driver.findElement(By.xpath("Harshit")).click();
		
		System.out.println("user click on the particular recipient name");
		
	   
	}

	@When("user Validate the data")
	public void user_Validate_the_data() {
		
		
	    
	}

	@Then("All data correct is created successfully under the recipient list")
	public void all_data_correct_is_created_successfully_under_the_recipient_list() {
	   
	}
}
