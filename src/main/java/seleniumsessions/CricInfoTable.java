package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CricInfoTable {
	
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get(
				"https://www.espncricinfo.com/series/wbbl-2022-23-1323553/adelaide-strikers-women-vs-perth-scorchers-women-20th-match-1323573/full-scorecard");

		Thread.sleep(4000);

		String wktTakerName = getWktTakerName("Amy Edgar");
		System.out.println(wktTakerName);
		getScoreCard("Maddy Green");
		
		

		driver.quit();

	}

	public static String getWktTakerName(String batsmanName) {
		String wkt_xpath = "//span[text()='"+batsmanName+"']/ancestor::td//following-sibling::td";
		String wktTakerName = driver.findElement(By.xpath(wkt_xpath)).getText();
		return wktTakerName;
	}
	
	public static void getScoreCard(String batsmanName) {

		List<WebElement> scoreList = driver
				.findElements(By.xpath("//span[text()='" + batsmanName + "']/ancestor::td//following-sibling::td"));

		for (WebElement e : scoreList) {
			String text = e.getText();
			System.out.println(text);
		}

	}

}
