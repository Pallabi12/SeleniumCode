package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleFrame {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.londonfreelance.org/courses/frames/index.html");
		
		System.out.println("No.of frames: "+ driver.findElements(By.tagName("frame")).size());
		
		//driver.switchTo().frame(2);
		driver.switchTo().frame("main");
		
		 String header = driver.findElement(By.xpath("/html/body/h2")).getText();
		 
		
		System.out.println(header);
		driver.quit();
	}

}
