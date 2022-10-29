package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTableTraverse {
	static WebDriver driver;

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://www.w3schools.com/html/html_tables.asp");
		
		System.out.println("No. of rows are: "+ getRowCount());
		System.out.println("No. of columns are: "+ getColumnCount());

		String xpath = "//table[@id='customers']//tr/td";

		List<WebElement> value = driver.findElements(By.xpath(xpath));

		for (WebElement e : value) {
			System.out.println(e.getText());
		}
		
		System.out.println("------------------------------");
		
//		String beforeXpath = "//table[@id='customers']//tbody/tr[";
//		String afterXpath = "]/td[1]";
//		
//		for(int i=2; i<=getRowCount()+1; i++) {
//			String actXpath = beforeXpath + i + afterXpath;
//			//System.out.println(actXpath);
//			String text = driver.findElement(By.xpath(actXpath)).getText();
//			System.out.println(text);
//		}
//
//		System.out.println("------------------------------");
//		
//		String b_beforeXpath = "//table[@id='customers']//tbody/tr[";
//		String b_afterXpath = "]/td[2]";
//		
//		for(int i=2; i<=getRowCount()+1; i++) {
//			String actXpath = b_beforeXpath + i + b_afterXpath;
//			//System.out.println(actXpath);
//			String text = driver.findElement(By.xpath(actXpath)).getText();
//			System.out.println(text);
//		}
//
//		System.out.println("------------------------------");
//		
//		String c_beforeXpath = "//table[@id='customers']//tbody/tr[";
//		String c_afterXpath = "]/td[3]";
//		
//		for(int i=2; i<=getRowCount()+1; i++) {
//			String actXpath = c_beforeXpath + i + c_afterXpath;
//			//System.out.println(actXpath);
//			String text = driver.findElement(By.xpath(actXpath)).getText();
//			System.out.println(text);
//		}
		
		getTableData(1);
		getTableData(2);
		getTableData(3);

		driver.quit();

	}
	
	public static void getTableData(int colnumber) {
		String beforeXpath = "//table[@id='customers']//tbody/tr[";
		String afterXpath = "]/td["+colnumber+"]";
		
		for(int i=2; i<=getRowCount()+1; i++) {
			String actXpath = beforeXpath + i + afterXpath;
			//System.out.println(actXpath);
			String text = driver.findElement(By.xpath(actXpath)).getText();
			System.out.println(text);
		}
	}

	public static int getRowCount() {
		int rows = driver.findElements(By.xpath("//table[@id='customers']//tr")).size();
		return rows - 1;
	}

	public static int getColumnCount() {
		int column = driver.findElements(By.xpath("//table[@id='customers']//tr/th")).size();
		return column;
	}
}
