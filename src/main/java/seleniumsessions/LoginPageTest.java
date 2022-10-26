package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageTest {

	public static void main(String[] args) throws Exception {
	
		BrowserUtil brutil = new BrowserUtil();
		WebDriver driver = brutil.launchBrowser("chrome");
		brutil.launchUrl("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		brutil.getPageTitle();
		
		 By email = By.id("input-email"); 
		 By password = By.id("input-password");
		 
		ElementUtil elutil = new ElementUtil(driver);
		elutil.doSendKeys(email, "test@gmail.com");
		elutil.doSendKeys(password, "test123");
		
		brutil.closeBrowser();

	}

}
