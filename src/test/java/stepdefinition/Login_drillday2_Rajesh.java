package stepdefinition;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Login_drillday2_Rajesh {

	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://elastic.rapidtestpro.com:2777/Vayu1";

	static final String USER = "belitypi";
	static final String PASSWORD = "47GWrkhPknA3";
	public static String baseurl = "http://elastic.rapidtestpro.com:8086/index";
	public static String username, password;
	WebDriver driver;
	LinkedList<String> gnames = new LinkedList<String>();

	@Given("^User reopens the bank application with the URL_Rajesh$")
	public void user_reopens_the_bank_application_with_the_URL_Rajesh() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(baseurl);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^User enters the login credentials_Rajesh$")
	public void user_enters_the_login_credentials_Rajesh()throws ClassNotFoundException, SQLException {
		
		Connection connection = null;
		Statement statement = null;

		Class.forName("com.mysql.cj.jdbc.Driver");
		connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
		statement = connection.createStatement();
		String query = "SELECT userName, passWord FROM Rajesh_Sign_Up;";
		ResultSet results = statement.executeQuery(query);

		while (results.next()) {

			username = results.getString("userName");
			driver.findElement(By.id("username")).sendKeys(username);
			password = results.getString("passWord");
			driver.findElement(By.id("password")).sendKeys(password);
			driver.findElement(By.xpath("//button[@class='btn btn-lg btn-primary btn-block']")).click();
			try {
				String login = driver.findElement(By.xpath("//h2[contains(text(),'Primary Balance:')]")).getText();
				Assert.assertEquals(login, "Primary Balance:", "Error in loading!");
				// obj.agile_project();
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				TakesScreenshot scr = ((TakesScreenshot) driver);
				File srcFile = scr.getScreenshotAs(OutputType.FILE);
				File destFile = new File("C:\\Users\\gyjkjehrhrhfhfhdgd\\Selenium Tutorial\\Screenshot\\drillday2.png");
				FileUtils.copyFile(srcFile, destFile);
			} catch (Exception e) {
				e.printStackTrace();
			}
			driver.findElement(By.xpath("//a[contains(text(),'Me')]")).click();
			driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();
		}
		results.close();
		statement.close();
		connection.close();
	}

	@Then("^User login will be successful$")
	public void user_login_will_be_successful() {

		System.out.println("Login Successful");

		driver.quit();

	}

}
