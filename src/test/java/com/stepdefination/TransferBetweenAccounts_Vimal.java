package com.stepdefination;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.helper.JDBCHelper;
import com.pageobject.PageObject;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TransferBetweenAccounts_Vimal extends PageObject {
	static WebDriver driver;
	static JDBCHelper jdbcObj;
	static int i;
	static String ammountValue;
	static String primaryBalance;

	@Given("^Launch the browser_Vimal$")
	public void launch_the_browser_Vimal() {

		WebDriverManager.chromedriver().driverVersion("83.0.4103.61").setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		jdbcObj = new JDBCHelper();

	}

	@When("^Navigate to the URL_Vimal$")
	public void navigate_to_the_URL_Vimal() {

		driver.get("http://elastic.rapidtestpro.com:8086/index");

	}

	@Given("^User enters the credentials and login to the application\"([^\"]*)\"_Vimal$")
	public void user_enters_the_credentials_and_login_to_the_application__Vimal(String arg1)
			throws ClassNotFoundException, SQLException {
		LinkedList<String> Names = new LinkedList<String>();
		LinkedList<String> Password = new LinkedList<String>();
		Names = jdbcObj.getUserName();
		Password = jdbcObj.getPassword();
		i = Integer.valueOf(arg1);
		driver.findElement(username).sendKeys(Names.get(i));
		driver.findElement(password).sendKeys(Password.get(i));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(signinButton).click();
		Assert.assertEquals(driver.findElement(homepageMessage).getText(), "Primary Balance:");
		primaryBalance = driver.findElement(primaryBal).getText();
	}

	@When("^Navigate to transfer between own accounts page_Vimal$")
	public void navigate_to_transfer_between_own_accounts_page_Vimal() {

		driver.findElement(transferButton).click();
		driver.findElement(betweenAcc).click();

	}

	@When("^User selects Primary to Savings transfer_Vimal$")
	public void user_selects_Primary_to_Savings_transfer_Vimal() throws ClassNotFoundException, SQLException {

		Select drpTransfer = new Select(driver.findElement(transferFrom));
		drpTransfer.selectByValue("Primary");
		LinkedList<String> Amnt = new LinkedList<String>();
		Amnt = jdbcObj.getAmount();
		ammountValue = Amnt.get(i);
		driver.findElement(amount).sendKeys(ammountValue);

		driver.findElement(confirmTransferButton).click();

	}

	@Then("^Fund Transfer is succesfull_Vimal$")
	public void fund_Transfer_is_succesfull_Vimal() {

		String pBal = driver.findElement(primaryBal).getText();
		if (primaryBalance != pBal) {
			System.out.println("Transaction is successful!");
		}
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.quit();

	}

	// *************************************************************************************************

	@When("^User selects Savings to Primary transfer_Vimal$")
	public void user_selects_Savings_to_Primary_transfer_Vimal() throws ClassNotFoundException, SQLException {

		Select drpTransfer = new Select(driver.findElement(transferFrom));
		drpTransfer.selectByValue("Savings");
		LinkedList<String> Amnt = new LinkedList<String>();
		Amnt = jdbcObj.getAmount();
		driver.findElement(amount).sendKeys(Amnt.get(i));
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(confirmTransferButton).click();

	}

	@When("^User selects Primary to Savings transfer and enters a invalid amount_Vimal$")
	public void user_selects_Primary_to_Savings_transfer_and_enters_a_invalid_amount_Vimal() throws ClassNotFoundException, SQLException {

		Select drpTransfer = new Select(driver.findElement(transferFrom));
		drpTransfer.selectByValue("Primary");
		LinkedList<String> Amnt = new LinkedList<String>();
		Amnt = jdbcObj.getAmount();
		ammountValue = Amnt.get(i);
		driver.findElement(amount).sendKeys(ammountValue);

		driver.findElement(confirmTransferButton).click();

	}

	@Then("^Fund Transfer is should be rejected_Vimal$")
	public void fund_Transfer_is_should_be_rejected_Vimal() {

		Assert.assertEquals(driver.findElement(homepageMessage2).getText(), "Primary Balance:");
		boolean fail = driver.findElement(homepageMessage2).isDisplayed();
		if(fail){
			System.out.println("System is accepting negative amount!");
		}
		
		else{
			System.out.println("System is not accepting negative amount!");
		}
		
		driver.quit();

	}

}
