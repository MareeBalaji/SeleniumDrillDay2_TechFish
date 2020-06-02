package StepDefinitionGuru99;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class RegistrationGuru99 {
	
	static WebDriver driver;
	
	@Given("User opnes the application with URL")
	public void user_opnes_the_application_with_URL() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("http://demo.guru99.com/test/newtours/register.php");
		
		driver.manage().window().maximize();
		// for the wait
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		System.out.print("User opnes the application with URL");
	    
	}

	@When("User inputs the valid username and valid password")
	public void user_inputs_the_valid_username_and_valid_password() {
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("Varun");
		driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys("Mishra");//input[@name='phone']
		driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("9125576833");
		driver.findElement(By.xpath("//input[@id='userName']")).sendKeys("varunmi@gmail.com");
		driver.findElement(By.xpath("//input[@name='address1']")).sendKeys("S-186 KDA colony");
		driver.findElement(By.xpath("//input[@name='city']")).sendKeys("Kanpur Nagar");
		
		driver.findElement(By.xpath("//input[@name='state']")).sendKeys("Uttar Pradesh");
		
		driver.findElement(By.xpath("//input[@name='postalCode']")).sendKeys("208013");////input[@id='email']
		driver.findElement(By.xpath("//select[@name='country']")).sendKeys("India");
		WebElement dropdown = driver.findElement(By.xpath("//select[@name='country']"));
        Select select = new Select(dropdown); 
       java.util.List<WebElement> options = select.getOptions(); 
        for(WebElement item:options) 
        { 
        
             System.out.println("Dropdown values are "+ item.getText());          
           }
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("varunmi123");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Varun@1996");
		driver.findElement(By.xpath("//input[@name='confirmPassword']")).sendKeys("Varun@1996");
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@When("User clicks on the login button")
	public void user_clicks_on_the_login_button() {
		driver.findElement(By.xpath("//input[@name='submit']")).click();
		System.out.println("Registration Successfully in Guru99");
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@Then("Sucessfully Login in the Guru99 Website")
	public void sucessfully_Login_in_the_Guru99_Website() throws IOException {
		driver.findElement(By.className("mouseOut")).click();
		driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("varunmi123");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Varun@1996");
		driver.findElement(By.xpath("//input[@name='submit']")).click();
		
		
		//Taking screenshot and saving in this path==>F:\\Software\\test.png
		TakesScreenshot scrShot =((TakesScreenshot)driver);
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
        File DestFile=new File("F:\\Software\\test.png");
        FileUtils.copyFile(SrcFile, DestFile);
        System.out.println("you r insede the  Guru99 Website ");
	    
	}
	 
}
