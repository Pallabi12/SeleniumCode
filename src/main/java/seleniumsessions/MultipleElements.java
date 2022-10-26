package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultipleElements {

	public static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://www.amazon.com");
//		driver.manage().window().maximize();
		List<WebElement> linklist = driver.findElements(By.tagName("a"));
		System.out.println("Total number of links: "+ linklist.size());
		
//		for(int i=0; i<linklist.size();i++) {
//			String link = linklist.get(i).getText();
//			if(link.length()!=0) {
//		System.out.println(link);
//			}
//		}

		for(WebElement c : linklist) {
			String e = c.getText();
			if(e.length()!=0) {
				System.out.println(e);
			}
			String hrefval = c.getAttribute("href");
			System.out.println(hrefval);
		}

		// ElementUtil eleutil = new ElementUtil(driver);

	}

}
