package seleniumsessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FooterLinks {
	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=common/home");

//		List<WebElement> footers = driver.findElements(By.xpath("//footer//a"));
//		System.out.println(footers.size());
//
//		for (WebElement e : footers) {
//			System.out.println(e.getText());
//		}
		
		By footers = By.xpath("//footer//a");
		
		ArrayList<String> actFooterList = getFooterLinkList(footers);
		
		if(actFooterList.contains("Contact Us")) {
			System.out.println("PASS");
		}

	}

	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}

	public static ArrayList<String> getFooterLinkList(By locator) {
		System.out.println(getElements(locator).size());
		ArrayList<String> eleTextList = new ArrayList<String>();

		for (WebElement e : getElements(locator)) {
			eleTextList.add(e.getText());
		}
		return eleTextList;
	}

}
