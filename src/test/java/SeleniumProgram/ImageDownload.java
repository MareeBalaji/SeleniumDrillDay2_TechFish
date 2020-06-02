package SeleniumProgram;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;


public class ImageDownload {
	
	//private static final String imageUrl= "";

	public static void main(String[] args) throws InterruptedException, AWTException    {
		// TODO Auto-generated method stub

		//d:\test
		
		//System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		 WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).sendKeys("lord krishna pick");
		driver.findElement(By.xpath("//div[@class='FPdoLc tfB0Bf']//input[@class='gNO89b']")).sendKeys(Keys.ENTER);
		
		// trying to Locate Image
		 // WebElement Image =driver.findElement(By.id("dimg_68"));
		WebElement Image = driver.findElement(By.xpath("//img[@id='dimg_45']"));
		//WebElement Image1 = driver.findElement(By.id("dimg_43"));
		
		
		
		 //Right click on Image using contextClick() method.
		  Actions action= new Actions(driver);
		  action.contextClick(Image).build().perform();
		  //action.moveToElement(Image, 100, 100);
		  
		//To perform press Ctrl + v keyboard button action.
		 //action.sendKeys(Keys.CONTROL, "s").build().perform();
		  //action.sendKeys(Keys.ARROW_DOWN, "s").click();
		  action.sendKeys(Keys.CONTROL, "v").build().perform();
		  
		  
		  Thread.sleep(3000);
		  Robot robot = new Robot();
		  
		  robot.keyPress(KeyEvent.VK_DOWN);
		  robot.keyRelease(KeyEvent.VK_DOWN);
		  //robot.keyPress(KeyEvent.VK_ENTER);
		  //robot.keyRelease(KeyEvent.VK_ENTER);
		  robot.keyPress(KeyEvent.VK_DOWN);
		  robot.keyRelease(KeyEvent.VK_DOWN);
		  
		  robot.keyPress(KeyEvent.VK_DOWN);
		  robot.keyRelease(KeyEvent.VK_DOWN);
		  
		  robot.keyPress(KeyEvent.VK_DOWN);
		  robot.keyRelease(KeyEvent.VK_DOWN);
		
		  
		  robot.keyPress(KeyEvent.VK_DOWN);
		  robot.keyRelease(KeyEvent.VK_DOWN);
		  
		  robot.keyPress(KeyEvent.VK_DOWN);
		  robot.keyRelease(KeyEvent.VK_DOWN);
		  // robot.keyPress(KeyEvent.VK_S);
		  
		  robot.keyPress(KeyEvent.VK_DOWN);
		  robot.keyRelease(KeyEvent.VK_DOWN);
		  
		  robot.keyPress(KeyEvent.VK_ENTER);
		  robot.keyRelease(KeyEvent.VK_ENTER);
		  
		  //BufferedImage saveImage = ImageIO.read(Image);
			//ImageIO.write(saveImage, "png", new File("F:\\Software\\varun_mishra.png"));
		  action.sendKeys(Keys.ENTER);
		  
		 
		  
		  Robot robot1 = new Robot();
		// press Ctrl+S the Robot's way
		robot1.keyPress(KeyEvent.VK_CONTROL);
		robot1.keyPress(KeyEvent.VK_S);
		robot1.keyRelease(KeyEvent.VK_CONTROL);
		robot1.keyRelease(KeyEvent.VK_S);
		// press Enter
		robot1.keyPress(KeyEvent.VK_ENTER);
		robot1.keyRelease(KeyEvent.VK_ENTER);
		  
		 //driver.close();
		  
		/* // robot.keyPress(KeyEvent.VK_ENTER);
		 //robot.keyPress(KeyEvent.VK_ENTER);//1
		 robot.keyPress(KeyEvent.VK_DOWN);
		 //robot.mousePress(KeyEvent.Arr);
		 System.out.println("Done-1"); 
		 //robot.keyPress(KeyEvent.VK_ENTER);//2
		 robot.keyPress(KeyEvent.VK_DOWN);
		 //System.out.println("Done-2"); 
		  //robot.keyPress(KeyEvent.VK_ENTER);//3
		 robot.keyPress(KeyEvent.VK_DOWN);
		 System.out.println("Done-3"); 
		 //robot.keyPress(KeyEvent.VK_ENTER);//4
		 robot.keyPress(KeyEvent.VK_DOWN);
		 System.out.println("Done-4"); 
		 //robot.keyPress(KeyEvent.VK_ENTER);//5
		 robot.keyPress(KeyEvent.VK_DOWN);
		 System.out.println("Done-5"); 
		// robot.keyPress(KeyEvent.VK_ENTER);//6
		 robot.keyPress(KeyEvent.VK_DOWN);
		 System.out.println("Done-6"); 
		// robot.keyPress(KeyEvent.VK_ENTER);//7
		 robot.keyPress(KeyEvent.VK_DOWN);
		 System.out.println("Done-7"); //8 
		 //robot.keyPress(KeyEvent.VK_ENTER); */
		
		 
		  
		  System.out.println("Done"); 
		
		
	}
	
}
	


