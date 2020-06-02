package SeleniumProgram;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;		
import java.util.concurrent.TimeUnit;		
import org.openqa.selenium.*;

public class BrokenLinkProgram {

	public static void main(String[] args) throws InterruptedException   {
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.get("https://maveric-systems.com/");
		driver.manage().window().maximize();
		 //To launch softwaretestingmaterial.com
		 
		 //Wait for 5 seconds
		 Thread.sleep(5000);
		 //Used tagName method to collect the list of items with tagName "a"
		 //findElements - to find all the elements with in the current page. It returns a list of all webelements or an empty list if nothing matches
		 List<WebElement> links = driver.findElements(By.tagName("a")); 
		 //To print the total number of links
		 System.out.println("Total links are "+links.size()); 
		 //used for loop to 
		 for(int i=0; i<links.size(); i++) {
		 WebElement element = links.get(i);
		 //By using "href" attribute, we could get the url of the requried link
		 String url=element.getAttribute("href");
		 //calling verifyLink() method here. Passing the parameter as url which we collected in the above link
		 //See the detailed functionality of the verifyLink(url) method below
		 verifyLink(url); 
		 } 
		 }	
	// The below function verifyLink(String urlLink) verifies any broken links and return the server status. 
	 public static void verifyLink(String urlLink) {
	        
	        try {
	 //Use URL Class - Create object of the URL Class and pass the urlLink as parameter 
	 URL link = new URL(urlLink);
	 // Create a connection using URL object (i.e., link)
	 HttpURLConnection httpConn =(HttpURLConnection)link.openConnection();
	 //Set the timeout for 2 seconds
	 httpConn.setConnectTimeout(2000);
	 //connect using connect method
	 httpConn.connect();
	 //use getResponseCode() to get the response code. 
	 if(httpConn.getResponseCode()== 200) { 
	 System.out.println(urlLink+" - "+httpConn.getResponseMessage());
	 }
	 if(httpConn.getResponseCode()== 404) {
	 System.out.println(urlLink+" - "+httpConn.getResponseMessage());
	 }
	 }
	 //getResponseCode method returns = IOException - if an error occurred connecting to the server. 
	 catch (Exception e) {
	 //e.printStackTrace();
	 }
	    } 
	
		    }		
		
	


