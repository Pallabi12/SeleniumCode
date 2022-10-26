package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebElementHandling {
	static WebDriver driver;

	public static void main(String[] args) throws Exception {

//		BrowserUtil brutil = new BrowserUtil();
//		brutil.launchBrowser("chrome");
//		brutil.launchUrl("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
//	

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");

//		1.
//		driver.findElement(By.id("input-email")).sendKeys("test@gmail.com");
//		driver.findElement(By.id("input-password")).sendKeys("test@123");

//		2.
//		WebElement email = driver.findElement(By.id("input-email"));
//		WebElement password = driver.findElement(By.id("input-password"));
//	
//		email.sendKeys("test@gmail.com");
//		password.sendKeys("test@123");

//		3. By Locator
		/*
		 * By email = By.id("input-email"); By password = By.id("input-password");
		 * 
		 * WebElement emailId = driver.findElement(email); 
		 * WebElement pwd = driver.findElement(password);
		 * 
		 * emailId.sendKeys("test@gmail.com"); pwd.sendKeys("test@123");
		 */

//		4. locator + generic function
		/*
		 * By email = By.id("input-email"); 
		 * By password = By.id("input-password");
		 * 
		 * getElement(email).sendKeys("test@gmail.com");
		 * getElement(password).sendKeys("test123");
		 */
		

//		5. By locator + getElement + actions generic function
		/*
		 * By email = By.id("input-email"); By password = By.id("input-password");
		 * 
		 * doSendKeys(email,"test@gmail.com"); doSendKeys(password,"test@123");
		 */
		 
//		 6. By Locator + ElementUtil --->generic function
		 By email = By.id("input-email"); 
		 By password = By.id("input-password");
		
		ElementUtil eleUtil = new ElementUtil(driver);
		eleUtil.doSendKeys(email, "test@gmail.com");
		eleUtil.doSendKeys(password, "test123");
		 
		 
	}

	
	public static void doSendKeys(By locator, String value) {
	getElement(locator).sendKeys(value);		
	}
	
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

}
