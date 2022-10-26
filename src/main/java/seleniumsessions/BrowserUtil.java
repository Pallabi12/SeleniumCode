package seleniumsessions;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserUtil {

	private WebDriver driver;

	/**
	 * this method is used to initialize browser on the basis of browser name
	 * 
	 * @param browser
	 */

	public WebDriver launchBrowser(String browser) {

		switch (browser.toLowerCase()) { // .toLowerCase will help in converting the browser input in lower case always.
											// So whatever input user give it will run
		case "chrome":
			//System.setProperty("webdriver.chrome.driver", "D:\\Softwares\\drivers\\chromedriver_win32\\chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "firefox":
			//System.setProperty("webdriver.gecko.driver", "D:\\Softwares\\drivers\\geckodriver.exe");
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "safari":
			driver = new SafariDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		default:
			System.out.println("please pass the correct browser");
			break;
		}
		return driver;
	}

	/**
	 * 
	 * this method is used to validate and launch url
	 * 
	 * @param url
	 * @throws Exception
	 */
	public void launchUrl(String url) throws Exception {
		if (url == null) {
			System.out.println("url is null");
			throw new Exception("URLISNULL");
		}

		if (url.length() == 0) {
			System.out.println("url is blank");
			throw new Exception("URLISBLANKEXCEPTION");
		}

		if (!url.contains("http")) {
			System.out.println("url does not have http or https");
			throw new Exception("MISSINGHTTPEXCEPTION");
		}

		driver.get(url);

	}

/**
 * this method is used to validate and launch url
 * @param url
 * @throws Exception
 */
	
	public void launchUrl(URL url) throws Exception {
		String newUrl = String.valueOf(url);
		
		
		if (newUrl == null) {
			System.out.println("url is null");
			throw new Exception("URLISNULL");
		}

		if (newUrl.length() == 0) {
			System.out.println("url is blank");
			throw new Exception("URLISBLANKEXCEPTION");
		}

		if (!newUrl.contains("http")) {
			System.out.println("url does not have http or https");
			throw new Exception("MISSINGHTTPEXCEPTION");
		}

		driver.navigate().to(url);
	}
	
	/**
	 * this method is used to get page title
	 * 
	 * @return
	 */
	public String getPageTitle() {
		String title = driver.getTitle();
		System.out.println("Title of the page is: " + title);
		if (title != null) {
			return title;
		} else {
			System.out.println("getting null title");
			return null;
		}
	}

	/**
	 * this method is used to get page url
	 * 
	 * @return
	 */
	public String getPageUrl() {
		String url = driver.getCurrentUrl();
		System.out.println("Url of the page is: " + url);
		if (url != null) {
			return url;
		} else {
			System.out.println("getting null title");
			return null;
		}
	}

	/**
	 * this method is used to close the browser
	 */
	public void closeBrowser() {
		if (driver != null) {
			driver.close();
			System.out.println("Browser is closed");
		}
	}

	/**
	 * this method is used to quit the browser
	 */
	public void quitBrowser() {
		if (driver != null) {
			driver.quit();
			System.out.println("Browser is closed");
		}
	}

}
