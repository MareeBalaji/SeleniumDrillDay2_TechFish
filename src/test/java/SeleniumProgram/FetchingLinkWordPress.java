package SeleniumProgram;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.List;

public class FetchingLinkWordPress {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.get("https://wordpress.com/?aff=58022&cid=8348279");
		driver.manage().window().maximize();
		  
		 //Get list of web-elements with tagName  - a
		 List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		  
		 //Traversing through the list and printing its text along with link address
		 for(WebElement link:allLinks){
		 System.out.println(link.getText() + " - " + link.getAttribute("href"));
		 }
		  
		 //Commenting driver.quit() for user to verify the links printed
		 driver.quit();
		

	}

}
