package Stepdefenition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;
public class Appoinment_nandhini {
	/*
	 * private static final String String = null; private static final
	 * java.lang.String DB_URL = null; private static final java.lang.String USER =
	 * null; private static final java.lang.String PASSWORD = null;
	 */
	static WebDriver driver;
	static String date,location,notes;
	
	@Given("^Open the URL$")
	public void open_the_URL() throws Throwable {
		WebDriverManager.chromedriver().setup();
	    driver =new ChromeDriver();
	    driver.get("http://elastic.rapidtestpro.com:8086/index");
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
   
	}

	@When("^when i enter \"([^\"]*)\" and password as \"([^\"]*)\"$")
	public void when_i_enter_and_password_as(String arg1, String arg2) throws Throwable {
	 driver.findElement(By.xpath("//input[@id='username']")).sendKeys(arg1);
	 driver.findElement(By.xpath("//input[@id='password']")).sendKeys(arg2);
	}

	@Then("^login should be sucessfull$")
	public void login_should_be_sucessfull() throws Throwable {
	    
		 driver.findElement(By.xpath("//button[@class='btn btn-lg btn-primary btn-block']")).click();
		 String ActualTitle = driver.getTitle();
		 System.out.println(ActualTitle);
		String ExpectedTitle = "User Front";
		    
		 Assert.assertEquals(ActualTitle, ExpectedTitle);
		 System.out.println("passed");
		 System.out.println("user sucessfully logged in");
	}
	@Given("^navigate to appoinment page$")
	public void navigate_to_appoinment_page() throws Throwable {
	    
		 driver.findElement(By.xpath("//a[@class='dropdown-toggle'][contains(text(),'Appointment')]")).click();   
		 driver.findElement(By.xpath("//a[contains(text(),'Schedule an Appointment')]")).click(); 
		 String ActualTitle = driver.getTitle();
		 System.out.println(ActualTitle);
		 System.out.println("appoinmnet page launched sucessfully");
	}

	@When("^enter the appoinment details$")
	public void enter_the_appoinment_details() throws Throwable {
	    
		 driver.findElement(By.xpath("//i[@class='fa fa-calendar']")).click();
		 driver.findElement(By.xpath("//div[@class='datetimepicker-days']//th[@class='today'][contains(text(),'Today')]")).click();
		 Select dropdown = new Select(driver.findElement(By.xpath("//select[@id='location']")));
	        List<WebElement> e= dropdown.getOptions();
	        int count = e.size();
	        for(int i=0; i<count; i++) {
	            System.out.println(e.get(i).getText());
	        }
	        dropdown.selectByVisibleText("Tampere");
	        driver.findElement(By.xpath("//textarea[@id='description']")).sendKeys("appoinment fixed");
	        
			
		//	Alert alert = driver.switchTo().alert();
	        WebDriverWait wait=new WebDriverWait(driver, 20);
			// driver.findElement(By.xpath("//button[@class='btn btn-primary' AND @data-bb-handler = 'confirm']")).click();
	         date = driver.findElement(By.xpath("//input[@id='dateString']")).getAttribute("value");
             System.out.println(date);
             location = driver.findElement(By.xpath("//select[@id='location']")).getAttribute("value");
             System.out.println(location);
             notes = driver.findElement(By.xpath("//textarea[@id='description']")).getAttribute("value");
             System.out.println(notes);
			 //alert.accept();
			/*
			 * date= driver.findElement(By.xpath("//input[@id='dateString']")).getText();
			 * System.out.println(date);
			 * location=(driver.findElement(By.xpath("//select[@id='location']"))).getText()
			 * ; System.out.println(location);
			 * notes=driver.findElement(By.xpath("//textarea[@id='description']")).getText()
			 * ; System.out.println(notes);
			 */
	        driver.findElement(By.xpath("//a[@id='submitAppointment']")).click();
	        driver.findElement(By.cssSelector("body.modal-open:nth-child(2) div.bootbox.modal.fade.bootbox-confirm.in:nth-child(5) div.modal-dialog div.modal-content div.modal-footer > button.btn.btn-primary:nth-child(2)")).click();
	}

	@When("^enter the Appoinment details to db$")
	public void enter_the_Appoinment_details_to_db() throws Throwable {
		Dbcall_nandhini obj=new Dbcall_nandhini();
		obj.dbcall(date,location,notes);
	}

	@Then("^logout of the system$")
	public void logout_of_the_system() throws Throwable {
		driver.findElement(By.xpath("//a[contains(text(),'Me')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();
	    driver.quit();
	    
	}
}
