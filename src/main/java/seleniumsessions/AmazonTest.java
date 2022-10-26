package seleniumsessions;

public class AmazonTest {

	public static void main(String[] args) throws Exception {
	
		String browser = "firefox";
		
		BrowserUtil brUtil = new BrowserUtil();
		brUtil.launchBrowser(browser);
		brUtil.launchUrl("https://www.amazon.com");
		
		String title = brUtil.getPageTitle();
		
		if(title.contains("Amazon")) {
			System.out.println("Correct Title ----- PASS");
		}
		else {
			System.out.println("InCorrect Title ----- FAIL");
		}
		
		brUtil.getPageUrl();
		brUtil.closeBrowser();
		 
	}

}
