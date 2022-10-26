package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class CrossBrowser {

	 static WebDriver driver;

	public static void main(String[] args) {

		String browser = "cHrome";

		// with switch logic

		switch (browser.toLowerCase()) { //.toLowerCase will help in converting the browser input in lower case always. So whatever input user give it will run
		case "chrome":
			System.setProperty("webdriver.chrome.driver",
					"D:\\Softwares\\drivers\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver", "D:\\Softwares\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		case "safari":
			driver = new SafariDriver();
			break;
		default:
			System.out.println("please pass the correct browser");
			break;
		}

		// with if else logic

		/*
		 * if (browser.equals("chrome")) { System.setProperty("webdriver.chrome.driver",
		 * "D:\\Softwares\\drivers\\chromedriver_win32\\chromedriver.exe"); driver = new
		 * ChromeDriver(); } else if (browser.equals("firefox")) {
		 * System.setProperty("webdriver.gecko.driver",
		 * "D:\\Softwares\\drivers\\geckodriver.exe"); driver = new FirefoxDriver(); }
		 * else if (browser.equals("safari")) { driver = new SafariDriver(); } else {
		 * System.out.println("please pass the correct browser"); }
		 */

		driver.get("https://www.google.com");
		System.out.println(driver.getTitle());
		driver.quit();

	}

}
