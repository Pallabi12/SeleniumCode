package seleniumsessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssignmentCheckbox {
	static WebDriver driver;
	
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://selectorshub.com/xpath-practice-page/");
		
		selectContact("Joe.Root");
		
	//	List<WebElement> detailList = driver.findElements(By.xpath("//a[text()='Joe.Root']/parent::td/following-sibling::td"));

		getUserDetails("Joe.Root");
	}

	
	
	public static void selectContact(String username) {
		driver.findElement(By.xpath("//a[text()='"+username+"']//parent::td/preceding-sibling::td/input[@type='checkbox']")).click();
	}
	
	
	public static ArrayList<String> getUserDetails(String username) {
		
		List<WebElement> detailList = driver.findElements(By.xpath("//a[text()='"+username+"']/parent::td/following-sibling::td"));
		ArrayList<String> detail = new ArrayList<String>();
		for(int i=0; i<detailList.size();i++) {
			String text = detailList.get(i).getText();
			detail.add(text);
			
		}
		System.out.println(detail);
		return detail;
		
	}
	
	
	
	
	
	
}


