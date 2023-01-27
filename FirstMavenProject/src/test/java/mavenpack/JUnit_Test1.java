package mavenpack;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import junit.framework.Assert;

public class JUnit_Test1 extends JUnitHTMLReporter{

	WebDriver driver; //accessible across the annotations
	@Before  	
	//Any activity needed before test starts like browser setup 
	public void setUp() throws Exception 
	{
		//Set the chromedriver path
		System.setProperty
		("webdriver.chrome.driver", 
				"C:\\Drivers_New\\BrowserDrivers\\chromedriver_win32 (1)\\chromedriver.exe");
        
			
		//Calling the ChromeDriver and maximizing the browser window
		driver = new ChromeDriver();
		driver.manage().window().maximize();

	       
		//Open browser URL
		String url = "https://demoqa.com/text-box";
		driver.get(url);
	}

	@After
	//Any activity needed after test finishes like browser setup 
	public void tearDown() throws Exception 
	{
		driver.quit(); //close browser
	}

	@Test
	public void test() 
	{
		//user name
		driver.findElement(By.id("userName")).sendKeys("Aparna Venugopal");
		
		//email
		driver.findElement(By.id("userEmail")).sendKeys("AVenu@abc.com");
		
		//c address
		WebElement cAddress = driver.findElement(By.id("currentAddress"));
		cAddress.sendKeys("123, Road 1, Street 2");
		
		//Actions class
		Actions actions = new Actions(driver);
		
		actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().perform();
		actions.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).build().perform();
		actions.sendKeys(Keys.TAB).build().perform();
		actions.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).build().perform();
		
		
		//Validations to be performed
		//Compare if the copied and pasted text is the same
		String currAddText = cAddress.getText();
		
		WebElement pAddress = driver.findElement(By.id("permanentAddress"));
		String permAddText = pAddress.getText();
		
		//Success case
		assertEquals(currAddText, permAddText);
				
	}
	
	@Test
	public void test2() 
	{
		//user name
				driver.findElement(By.id("userName")).sendKeys("Aparna Venugopal");
				
				//email
				driver.findElement(By.id("userEmail")).sendKeys("AVenu@abc.com");
				
				//c address
				WebElement cAddress = driver.findElement(By.id("currentAddress"));
				cAddress.sendKeys("123, Road 1, Street 2");
				
				//Actions class
				Actions actions = new Actions(driver);
				
				actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().perform();
				actions.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).build().perform();
				actions.sendKeys(Keys.TAB).build().perform();
				actions.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).build().perform();
				
				
				//Validations to be performed
				//Compare if the copied and pasted text is the same
				String currAddText = cAddress.getText();
				
				WebElement pAddress = driver.findElement(By.id("permanentAddress"));
				String permAddText = pAddress.getText();
				
				//Failure case
				assertEquals(currAddText, "Drop");
	}
}


