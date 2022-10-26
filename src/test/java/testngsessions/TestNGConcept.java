package testngsessions;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGConcept {
	
	
	/**
	 *  BS -- connectWithDB
		BT -- connectTestUser
		BC -- launchBrowser
		
			BM-- login
			addToCart test
			AM -- Logout

			BM-- login
			payment test
			AM -- Logout

			BM-- login
			search test
			AM -- Logout

		AC -- Close Browser
		AT -- Delete User
PASSED: addToCartTest
PASSED: paymentTest
PASSED: searchTest
		AS -- Disconnect with DB
	 */
	
	@BeforeSuite
	public void connectWithDB() {
		System.out.println("BS -- connectWithDB");
	}
	
	
	@BeforeTest
	public void connectTestUser() {
		System.out.println("BT -- connectTestUser");
	}

	
	@BeforeClass
	public void launchBrowser() {
		System.out.println("BC -- launchBrowser");
	}

	@BeforeMethod
	public void login() {
		System.out.println("BM-- login");
	}
	
	@Test
	public void searchTest() {
		System.out.println("search test");
	}
	
	@Test
	public void addToCartTest() {
		System.out.println("addToCart test");
	}
	
	@Test
	public void paymentTest() {
		System.out.println("payment test");
	}
	
	@AfterMethod
	public void logout() {
		System.out.println("AM -- Logout");
	}
	
	@AfterClass
	public void closeBrowser() {
		System.out.println("AC -- Close Browser");
	}
	
	@AfterTest
	public void deleteUser() {
		System.out.println("AT -- Delete User");
	}
	
	@AfterSuite
	public void disconnectWithDB() {
		System.out.println("AS -- Disconnect with DB");
	}
	
}
