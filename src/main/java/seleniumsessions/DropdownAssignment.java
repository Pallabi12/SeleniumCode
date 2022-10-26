package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropdownAssignment {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php?");

//		WebElement searchBar = driver.findElement(By.xpath("//input[@id='search_query_top']"));
//		searchBar.sendKeys("dress");
//
//		Thread.sleep(10000);
//
//		List<WebElement> optionlist = driver.findElements(By.xpath("//div[@class='ac_results']//li"));
//
//		System.out.println(optionlist.size());
//
//		for (WebElement e : optionlist) {
//			System.out.println(e.getText());
//			if (e.getText().equals("Casual Dresses > Printed Dress")) {
//				e.click();
//				break;
//			}
//
//		}
//		WebElement name = driver.findElement(By.tagName("h1"));
//		if (name.getText().equals("Printed Dress")) {
//			System.out.println("PASS");
//		} else
//			System.out.println("FAIL");

		By searchBar = By.xpath("//input[@id='search_query_top']");
		By list = By.xpath("//div[@class='ac_results']//li");
		By name = By.tagName("h1");

		sendKeys(searchBar, "dress");

		Thread.sleep(10000);

		List<WebElement> optionlist = getElements(list);
		System.out.println(optionlist.size());

		search(name, optionlist, "Casual Dresses > Printed Dress");

	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}

	public static void search(By locator, List<WebElement> optionlist, String value) {
		for (WebElement e : optionlist) {
			System.out.println(e.getText());
			if (e.getText().equals(value)) {
				e.click();
				break;
			}
		}
		WebElement name = driver.findElement(locator);
		if (name.getText().equals("Printed Dress")) {
			System.out.println("PASS");
		} else
			System.out.println("FAIL");

	}

	public static void sendKeys(By locator, String text) {
		getElement(locator).sendKeys(text);
	}
}
