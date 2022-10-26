package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverBasics {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "D:\\Softwares\\drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");

		String title = driver.getTitle();
		System.out.println(title);
		if (title.equals("Google")) {
			System.out.println("PASS");
		} else {
			System.out.println("FAIL");
		}

		String url = driver.getCurrentUrl();
		System.out.println(url);

		String source = driver.getPageSource();
		//System.out.println(source);
		if (source.contains("Copyright The Closure Library Authors.")) {
			System.out.println("PASS");
		} else {
			System.out.println("FAIL");
		}
		
		driver.quit();
		
		System.out.println(driver.getTitle());
	}

}
