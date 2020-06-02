package stepDefinition;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Deposit_Maree {
	static WebDriver driver;
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://elastic.rapidtestpro.com:2777/Vayu1";
	static final String USER = "belitypi";
	static final String PASSWORD = "47GWrkhPknA3";
	
	@Given("^Sigin-In TechFishBank Application and Validate Dashboard_Maree$")
	public void sigin_In_TechFishBank_Application_and_Validate_Dashboard_Maree() throws AWTException, IOException, ClassNotFoundException, SQLException{
		
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.get("http://elastic.rapidtestpro.com:8086/index");
		driver.manage().window().maximize();
		Connection connection = null;
		Statement statement = null;
		Class.forName("com.mysql.cj.jdbc.Driver");
		connection = DriverManager.getConnection(DB_URL,USER,PASSWORD);
		statement = connection.createStatement();
		String query = "SELECT * FROM Maree where ScriptName ='PrimaryDeposit';";
		ResultSet results = statement.executeQuery(query);
		results.next();
		String username = results.getString("UserName");
		String password = results.getString("Password");
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
		driver.findElement(By.xpath("//button[@class='btn btn-lg btn-primary btn-block']")).click();
		String actual = driver.findElement(By.xpath("//div[contains(text(),'Deposit')]")).getText();
		if (actual.equalsIgnoreCase("Deposit"))
		{
			Robot robot1 = new Robot();
			java.awt.Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			Rectangle screenRectangle = new Rectangle(screenSize);
	        BufferedImage image = robot1.createScreenCapture(screenRectangle);
	        File Des = new File(".//screenshot//Dashboard_PrimaryAccount.png");
	        ImageIO.write(image, "png", Des);
	        
		}

	}

	@When("^Perform and Validate multiple Deposit for Primary Account_Maree$")
	public void perform_and_Validate_multiple_Deposit_for_Primary_Account_Maree() throws SQLException, ClassNotFoundException, IOException, AWTException{
		
		Connection connection = null;
		Statement statement = null;
		Class.forName("com.mysql.cj.jdbc.Driver");
		connection = DriverManager.getConnection(DB_URL,USER,PASSWORD);
		statement = connection.createStatement();
		String query = "SELECT * FROM Maree where ScriptName ='PrimaryDeposit';";
		ResultSet results = statement.executeQuery(query);
		int i = 1;
		while(results.next())
		{
		String DepositAmount = results.getString("DepositAmount");
		String originalbalance = driver.findElement(By.cssSelector("div.container.main:nth-child(2) div.row:nth-child(2) div.col-lg-6.col-md-6:nth-child(1) div.panel.panel-info:nth-child(1) div.panel-heading:nth-child(1) div.row div.col-xs-6.text-right:nth-child(2) h1:nth-child(1) > span:nth-child(2)")).getText();
		//String suboriginalbalance = originalbalance.substring(0, 3);
		//System.out.println(suboriginalbalance);
		double orbalance = Double.parseDouble(originalbalance);
		double depoamount = Double.parseDouble(DepositAmount);
		driver.findElement(By.xpath("//span[contains(text(),'Go to Deposit')]")).click();
		driver.findElement(By.xpath("//option[contains(text(),'Primary')]")).click();
		driver.findElement(By.xpath("//input[@id='amount']")).sendKeys(DepositAmount);
		driver.findElement(By.xpath("//button[@class='btn btn-lg btn-primary btn-block']")).click();
		String AfterDepositbalance = driver.findElement(By.cssSelector("div.container.main:nth-child(2) div.row:nth-child(2) div.col-lg-6.col-md-6:nth-child(1) div.panel.panel-info:nth-child(1) div.panel-heading:nth-child(1) div.row div.col-xs-6.text-right:nth-child(2) h1:nth-child(1) > span:nth-child(2)")).getText();
		//String subAfterDepositbalance = AfterDepositbalance.substring(0, 3);
		double afdeposit = Double.parseDouble(AfterDepositbalance);
		//System.out.println(afdeposit);
		double balance = orbalance+ depoamount;
		System.out.println("Primary Account Balance: "+balance);
		if (afdeposit == balance)
		{
			String Updatequery = "UPDATE `Maree` SET `TestResult`='Pass' WHERE `ScriptName` ='PrimaryDeposit' AND `Iteration`='Deposit"+i+"';";
			PreparedStatement preparedStmt = connection.prepareStatement(Updatequery);
			System.out.println(preparedStmt);
			preparedStmt.executeUpdate();
			Robot robot1 = new Robot();
			java.awt.Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			Rectangle screenRectangle = new Rectangle(screenSize);
	        BufferedImage image = robot1.createScreenCapture(screenRectangle);
	        File Des = new File(".//screenshot//PrimaryAccountDeposit_"+DepositAmount+".png");
	        ImageIO.write(image, "png", Des);
			
		}
		else 
		{
			String Updatequery = "UPDATE `Maree` SET `TestResult`='Fail' WHERE `ScriptName` ='PrimaryDeposit' AND `Iteration`='Deposit"+i+"';";
			PreparedStatement preparedStmt = connection.prepareStatement(Updatequery);
			System.out.println(preparedStmt);
			preparedStmt.executeUpdate();
			Robot robot1 = new Robot();
			java.awt.Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			Rectangle screenRectangle = new Rectangle(screenSize);
	        BufferedImage image = robot1.createScreenCapture(screenRectangle);
	        File Des = new File(".//screenshot//Failed_To_PrimaryDeposit"+DepositAmount+".png");
	        ImageIO.write(image, "png", Des);
		}
		i = i+1;
		}
		results.close();
		statement.close();
		connection.close();
		}

	@Then("^Signout TechFishBank Application _Maree$")
	public void signout_TechFishBank_Application__Maree(){
		driver.findElement(By.xpath("//a[contains(text(),'Me')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();
		try {
			driver.findElement(By.xpath("//div[@class='bg-danger']")).isDisplayed();
			System.out.println("Loged out Sucessfuly");
		}
		catch(Exception e)
		{
			System.out.println("Not Loged out Sucessfuly");
		}
		driver.close();
	}

	@Given("^Sigin-In with Multiple users \"([^\"]*)\" TechFishBank Application and Validate Dashboard_Maree$")
	public void sigin_In_with_Multiple_users_TechFishBank_Application_and_Validate_Dashboard_Maree(String arg1) throws AWTException, IOException, ClassNotFoundException, SQLException{
		
		Connection connection = null;
		Statement statement = null;
		Class.forName("com.mysql.cj.jdbc.Driver");
		connection = DriverManager.getConnection(DB_URL,USER,PASSWORD);
		statement = connection.createStatement();
		//String query = """+arg1+""";
		ResultSet results = statement.executeQuery(arg1);
		results.next();
		String username = results.getString("UserName");
		String password = results.getString("Password");
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.get("http://elastic.rapidtestpro.com:8086/index");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
		driver.findElement(By.xpath("//button[@class='btn btn-lg btn-primary btn-block']")).click();
		String actual = driver.findElement(By.xpath("//div[contains(text(),'Deposit')]")).getText();
		if (actual.equalsIgnoreCase("Deposit"))
		{
			Robot robot1 = new Robot();
			java.awt.Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			Rectangle screenRectangle = new Rectangle(screenSize);
	        BufferedImage image = robot1.createScreenCapture(screenRectangle);
	        File Des = new File(".//screenshot//Dashboard"+username+".png");
	        ImageIO.write(image, "png", Des);
	        
		}
		results.close();
		statement.close();
		connection.close();

	}

	@When("^Perform and Validate multiple Deposit \"([^\"]*)\"for Savings Account_Maree$")
	public void perform_and_Validate_multiple_Deposit_for_Savings_Account_Maree(String arg1) throws ClassNotFoundException, SQLException, AWTException, IOException{
		Connection connection = null;
		Statement statement = null;
		Class.forName("com.mysql.cj.jdbc.Driver");
		connection = DriverManager.getConnection(DB_URL,USER,PASSWORD);
		statement = connection.createStatement();
		//String query =arg1;
		ResultSet results = statement.executeQuery(arg1);
		results.next();
		String DepositAmount = results.getString("DepositAmount");
		String originalbalance = driver.findElement(By.cssSelector("div.container.main:nth-child(2) div.row:nth-child(2) div.col-lg-6.col-md-6:nth-child(1) div.panel.panel-success:nth-child(2) div.panel-heading:nth-child(1) div.row div.col-xs-6.text-right:nth-child(2) h1:nth-child(1) > span:nth-child(2)")).getText();
		//String suboriginalbalance = originalbalance.substring(0, 3);
		//System.out.println(suboriginalbalance);
		double orbalance = Double.parseDouble(originalbalance);
		double depoamount = Double.parseDouble(DepositAmount);
		driver.findElement(By.xpath("//span[contains(text(),'Go to Deposit')]")).click();
		driver.findElement(By.xpath("//option[contains(text(),'Savings')]")).click();
		driver.findElement(By.xpath("//input[@id='amount']")).sendKeys(DepositAmount);
		driver.findElement(By.xpath("//button[@class='btn btn-lg btn-primary btn-block']")).click();
		String AfterDepositbalance = driver.findElement(By.cssSelector("div.container.main:nth-child(2) div.row:nth-child(2) div.col-lg-6.col-md-6:nth-child(1) div.panel.panel-success:nth-child(2) div.panel-heading:nth-child(1) div.row div.col-xs-6.text-right:nth-child(2) h1:nth-child(1) > span:nth-child(2)")).getText();
		//String subAfterDepositbalance = AfterDepositbalance.substring(0, 3);
		double afdeposit = Double.parseDouble(AfterDepositbalance);
		System.out.println(afdeposit);
		double balance = orbalance+ depoamount;
		System.out.println("Savings Account Balance: "+balance);
		if (afdeposit == balance)
		{
			String Updatequery = "UPDATE `Maree` SET `TestResult`='Pass' WHERE `ScriptName` ='SavingsDeposit' AND `DepositAmount`='"+DepositAmount+"';";
			PreparedStatement preparedStmt = connection.prepareStatement(Updatequery);
			System.out.println(preparedStmt);
			preparedStmt.executeUpdate();
			Robot robot1 = new Robot();
			java.awt.Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			Rectangle screenRectangle = new Rectangle(screenSize);
	        BufferedImage image = robot1.createScreenCapture(screenRectangle);
	        File Des = new File(".//screenshot//SavingsAccountDeposit_"+DepositAmount+".png");
	        ImageIO.write(image, "png", Des);
			
		}
		else 
		{
			String Updatequery = "UPDATE `Maree` SET `TestResult`='Fail' WHERE `ScriptName` ='SavingsDeposit' AND `DepositAmount`='"+DepositAmount+"';";
			PreparedStatement preparedStmt = connection.prepareStatement(Updatequery);
			System.out.println(preparedStmt);
			preparedStmt.executeUpdate();
			Robot robot1 = new Robot();
			java.awt.Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			Rectangle screenRectangle = new Rectangle(screenSize);
	        BufferedImage image = robot1.createScreenCapture(screenRectangle);
	        File Des = new File(".//screenshot//Failed_To_SavingsDeposit_"+DepositAmount+".png");
	        ImageIO.write(image, "png", Des);
		}
		results.close();
		statement.close();
		connection.close();
		}
	}

