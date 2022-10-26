package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AuthPopUpHandle {

	public static void main(String[] args) {
	
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		String username = "admin";
		String password ="admin";
		
		driver.get("https://"+username+":"+password+"@the-internet.herokuapp.com/basic_auth");
		
		String cnfmMsg = driver.findElement(By.tagName("p")).getText();
		System.out.println(cnfmMsg);
		
		if(cnfmMsg.contains("Congratulations! You must have the proper credentials.")) {
			System.out.println("Pass");
		}else {
			System.out.println("Fail");
		}

	}

}
