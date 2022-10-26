package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownWithoutSelect {
	static WebDriver driver;
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/?");
		
		////select/option - 232
		
		//List<WebElement> countryList = driver.findElements(By.xpath("//select/option"));
		
		By countrydropdown = By.xpath("//select/option");
		
	//	System.out.println(countryList.size());
		
		doSelectValueFromDropDown(countrydropdown, "Germany");
		
		
//		for(WebElement e : countryList) {
//			System.out.println(e.getText());
//			
//			if(e.getText().equals("India")) {
//				e.click();
//				break;
//			}
//		}
		
	//	driver.close();

	}

	public static void doSelectValueFromDropDown(By locator, String value) {
		List<WebElement> optionsList = driver.findElements(locator);
		System.out.println(optionsList.size());
		for(WebElement e : optionsList) {
			System.out.println(e.getText());
			if(e.getText().equals(value)) {
				e.click();
				break;
			}
		}
	}
	
}


