package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumException {

	static WebDriver driver;
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/");
		
		//driver.findElement(By.name("search11")).sendKeys("macbook pro");
		//noSuchElementException - Selenium Exception
		//ElementNotFoundException - not in selenium. It is a Java Exception
		
		List<WebElement> footers = driver.findElements(By.xpath("//footer//pallabi"));
		System.out.println(footers.size());
		//return empty list -- size -- 0
		
	}

	public static boolean isSingleElementPresent(By locator) {
		List<WebElement> list =driver.findElements(locator);
		System.out.println(list.size());
		
		if(list.size()==1) {
			System.out.println("Single search element is present on the page");
			return true;
		}else {
			System.out.println("No search or multiple search is present on the page");
			return false;
		}
			
	}
}
