package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPageTest {

	public static void main(String[] args) throws Exception {
	
		BrowserUtil brutil = new BrowserUtil();
		WebDriver driver = brutil.launchBrowser("chrome");
		
		brutil.launchUrl("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		brutil.getPageTitle();
		
		By search = By.name("search");
		
		By firstName = By.id("input-firstname");
		By lastName = By.id("input-lastname");
		By email = By.id("input-email");
		By telephone = By.id("input-telephone");
		By password = By.id("input-password");
		By pwdcnfirm = By.id("input-confirm");
		By fname = By.xpath("//*[@id=\"account\"]/div[2]/label");
		By continueBtn = By.xpath("//input[@value='Continue']");
		By wrn = By.className("alert-danger");
		By wfn = By.xpath("//*[@id=\"account\"]/div[2]/div/div");
		
		ElementUtil eleutil = new ElementUtil(driver);
		
		
		if(eleutil.doEleIsDisplayed(search)) {
			System.out.println("Element is displayed");
		}else
			System.out.println("Element is not displayed");
		
		
	
		
		eleutil.doClick(continueBtn);
		String warn = eleutil.doGetText(wrn);
		System.out.println(warn);
		String wfname = eleutil.doGetText(wfn);
		System.out.println(wfname);
		
		
		
		eleutil.doSendKeys(firstName, "Pallabi");
		eleutil.doSendKeys(lastName, "Bhar");
		eleutil.doSendKeys(email, "test@gmail.com");
		eleutil.doSendKeys(telephone, "9999888766");
		eleutil.doSendKeys(password, "Test123");
		eleutil.doSendKeys(pwdcnfirm, "Test123");
		
		String Fname = eleutil.doGetText(fname);
		System.out.println(Fname);
		
	String attr = eleutil.getElement(lastName).getAttribute("id");
	
	String attr1 = eleutil.getElement(lastName).getAttribute("value");
	
	System.out.println("Attr of lname is: "+ attr);
	System.out.println("value of lname is: "+ attr1);
		
					
		brutil.quitBrowser();
	}

}
