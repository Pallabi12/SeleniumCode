package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebElementClick {
		
	public static WebDriver driver;
		
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		getUrl("https://app.hubspot.com/login");
		
		By username = By.id("username");
		By password = By.id("password");
		By loginBtn = By.id("loginBtn");
		
		doSendKeys(username, "test@gmail.com");
		doSendKeys(password, "test1234");
		
		doClick(loginBtn);		
		
		
	}

	public static void getUrl(String url) {
		driver.get(url);
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static void doSendKeys(By locator, String value) {
		getElement(locator).sendKeys(value);
	}
	
	public static void doClick(By locator) {
		getElement(locator).click();
	}
	
}
