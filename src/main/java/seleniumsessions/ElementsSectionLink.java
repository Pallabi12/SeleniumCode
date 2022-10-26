package seleniumsessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ElementsSectionLink {

	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		By SectionLists = By.className("list-group-item");
		
		
		ElementUtil eleutil = new ElementUtil(driver);
		ArrayList<String> textList = eleutil.getElementsTextList(SectionLists);
		
		System.out.println(textList);

		if (textList.contains("Order History")){
			System.out.println("Pass");
		}else {
			System.out.println("Fail");
		}
//		List<WebElement> SectionLists = driver.findElements(By.className("list-group-item"));
//
//		System.out.println(SectionLists.size());
//		
//		for(WebElement e: SectionLists) {
//			String text = e.getText();
//			System.out.println(text);
//		}
//		
		driver.close();
	}

}
