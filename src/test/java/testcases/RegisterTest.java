package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RegisterTest {

	WebDriver driver;

	@BeforeTest
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
	}
	
	@DataProvider
	public Object[][] registerDetails(){
		return new Object[][] {
			{"Pallabi","Bhar"," ","87@87","password"},
			{"@#$sd","Bhar","pallabi@gmail.com","8787"," "},
			{"Pallabi","hjjghj@$$$"," ","8787","password"},
			{" "," "," "," "," "}
		};
		
	}
	
	@Test(dataProvider = "registerDetails")
	public void enterRegisterDetailsTest(String fname, String lname, String email, String number, String password) {
		Assert.assertEquals(addRegisterDetails(fname,lname,email,number,password), true);
	}
	
	
	public boolean addRegisterDetails(String fname, String lname, String email, String number, String password) {
		driver.findElement(By.id("input-firstname")).clear();
		driver.findElement(By.id("input-firstname")).sendKeys(fname);
		
		driver.findElement(By.id("input-lastname")).clear();
		driver.findElement(By.id("input-lastname")).sendKeys(lname);
		
		driver.findElement(By.id("input-email")).clear();
		driver.findElement(By.id("input-email")).sendKeys(email);
		
		driver.findElement(By.id("input-telephone")).clear();
		driver.findElement(By.id("input-telephone")).sendKeys(number);
		
		driver.findElement(By.id("input-password")).clear();
		driver.findElement(By.id("input-password")).sendKeys(password);
		
		driver.findElement(By.id("input-confirm")).clear();
		driver.findElement(By.id("input-confirm")).sendKeys(password);
		
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		if(driver.findElement(By.cssSelector("div.alert.alert-danger.alert-dismissible")).isDisplayed()) {
			return true;
		}else {
			return false;
		}
		
	
	}
	
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

	
}
