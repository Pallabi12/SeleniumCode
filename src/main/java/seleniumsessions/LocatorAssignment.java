package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/***
 * 
 * @author PALLABI
 * Selenium Session 6
 *
 */

public class LocatorAssignment {

	public static void main(String[] args) throws Exception {
		
		BrowserUtil brutil = new BrowserUtil();
		WebDriver driver = brutil.launchBrowser("chrome");
		
		brutil.launchUrl("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		brutil.getPageTitle();
		
		driver.manage().window().fullscreen();
		
		//Login page
		By email = By.name("email");
		By password = By.name("password");
		By login = By.xpath("//input[@value ='Login']");
		
		ElementUtil eleutil = new ElementUtil(driver);
		eleutil.doSendKeys(email, "test@gmail.com");
		eleutil.doSendKeys(password, "Test123");
		eleutil.doClick(login);
		
		//Registration page
		
		By register = By.linkText("Register");
		
		eleutil.doClick(register);
		
	//	Thread.sleep(2000);
		
		By firstName = By.id("input-firstname");
		By lastName = By.id("input-lastname");
		By regEmail = By.id("input-email");
		By telephone = By.id("input-telephone");
		By regPassword = By.id("input-password");
		By pwdcnfirm = By.id("input-confirm");
		
		eleutil.doSendKeys(firstName, "Pallabi");
		eleutil.doSendKeys(lastName, "Bhar");
		eleutil.doSendKeys(regEmail, "test@gmail.com");
		eleutil.doSendKeys(telephone, "9999888766");
		eleutil.doSendKeys(regPassword, "Test123");
		eleutil.doSendKeys(pwdcnfirm, "Test123");
		
		driver.navigate().back();
		
		By forgotPassword = By.linkText("Forgotten Password");
		By back = By.linkText("Back");
		
		eleutil.doClick(forgotPassword);
		eleutil.doClick(back);
		
		driver.navigate().forward();


		
		
	}

}
