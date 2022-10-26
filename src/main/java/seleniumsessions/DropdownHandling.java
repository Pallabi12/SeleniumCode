package seleniumsessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropdownHandling {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		
		//sendkeys can be added with webelement to select a dropdown in case the dropdown has select tag
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/?");
		
		WebElement dropdown = driver.findElement(By.id("Form_getForm_Country"));
//		
		Select sel = new Select(dropdown);
		
		List<WebElement> countryOptions = sel.getOptions();
		
	 	System.out.println("Total options: " + (countryOptions.size()-1));
		
//		for(WebElement e : countryOptions) {
//			String text = e.getText();
//			System.out.println(text);
//		}
	 	
	 	By country = By.id("Form_getForm_Country");
	 	
	 	System.out.println(getElementsTextDropdown(country));
	 	
	 	
//		
//		//sel.selectByIndex(5);
//		
//		sel.selectByVisibleText("Afghanistan");
//		Thread.sleep(2000);
//		System.out.println("----af---");
//		dropdown.sendKeys("India");
		
	//	By country = By.id("Form_getForm_Country");
		
		//doSelectDropdownByVisibleText(country,"Belgium");
		//doSelectDropdownByValue(country, "India");
		//doSelectDropdownByIndex(country, 37);
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
		
	}
	
	public static void doSelectDropdownByValue(By locator, String Value) {
		Select select = new Select(getElement(locator));
		select.selectByValue(Value);
	}
	
	public static void doSelectDropdownByIndex(By locator, int index) {
		Select select = new Select(getElement(locator));
		select.selectByIndex(index);
	}
	
	public static void doSelectDropdownByVisibleText(By locator, String text) {
		Select select = new Select(getElement(locator));
		select.selectByVisibleText(text);
	}
	
	public static List<WebElement> getDropdownOptions(By locator) {
		Select select = new Select(getElement(locator));
		return select.getOptions();
	}
	
	public static int doSelectDropdownOptionsCount(By locator) {
		return getDropdownOptions(locator).size();
	}
	
	
	public static ArrayList<String> getElementsTextDropdown(By locator) {
		List<WebElement> dropdownList = getDropdownOptions(locator);
		ArrayList<String> eleTextList = new ArrayList<String>();
		for (WebElement e : dropdownList) {
			String text = e.getText();
			if (text.length() != 0) {
				eleTextList.add(text);
			}

		}
		return eleTextList;
	}
	
}

