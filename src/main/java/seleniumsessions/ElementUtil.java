package seleniumsessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ElementUtil {

	private WebDriver driver;
	private Select select;

	public ElementUtil(WebDriver driver) {
		this.driver = driver;

	}

	public void doSendKeys(By locator, String value) {
		getElement(locator).sendKeys(value);
	}

	public List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}

	public WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public void doClick(By locator) {
		getElement(locator).click();
	}

	public String doGetText(By locator) {
		return getElement(locator).getText();
	}

	public String doGetAttribute(By locator, String attrName) {
		return getElement(locator).getAttribute(attrName);
	}

	public boolean doEleIsDisplayed(By locator) {
		return getElement(locator).isDisplayed();
	}

	public boolean isSingleElementPresent(By locator) {
		List<WebElement> list = getElements(locator);
		System.out.println(list.size());

		if (list.size() == 1) {
			System.out.println("Single search element is present on the page");
			return true;
		} else {
			System.out.println("No search or multiple search is present on the page");
			return false;
		}

	}
	
	public ArrayList<String> getFooterLinkList(By locator) {
		System.out.println(getElements(locator).size());
		ArrayList<String> eleTextList = new ArrayList<String>();

		for (WebElement e : getElements(locator)) {
			eleTextList.add(e.getText());
		}
		return eleTextList;
	}

	public int getElementsCount(By locator) {
		return driver.findElements(locator).size();
	}

	public ArrayList<String> getElementsTextList(By locator) {
		List<WebElement> eleList = getElements(locator);
		ArrayList<String> eleTextList = new ArrayList<String>();
		for (WebElement e : eleList) {
			String text = e.getText();
			if (text.length() != 0) {
				eleTextList.add(text);
			}

		}
		return eleTextList;
	}

	// ********************Drop Down Utils**************************
	// only when html tag = <select>

	public void doSelectDropdownByValue(By locator, String Value) {
		select = new Select(getElement(locator));
		select.selectByValue(Value);
	}

	public void doSelectDropdownByIndex(By locator, int index) {
		select = new Select(getElement(locator));
		select.selectByIndex(index);
	}

	public void doSelectDropdownByVisibleText(By locator, String text) {
		select = new Select(getElement(locator));
		select.selectByVisibleText(text);
	}

	public List<WebElement> getDropdownOptions(By locator) {
		select = new Select(getElement(locator));
		return select.getOptions();
	}

	public int doSelectDropdownOptionsCount(By locator) {
		return getDropdownOptions(locator).size();
	}

	public void doSelectValueFromDropDown(By locator, String value) {
		List<WebElement> optionsList = getElements(locator);
		System.out.println(optionsList.size());
		for (WebElement e : optionsList) {
			System.out.println(e.getText());
			if (e.getText().equals(value)) {
				e.click();
				break;
			}
		}
	}

	public ArrayList<String> getElementsTextDropdown(By locator) {
		List<WebElement> dropdownList = getDropdownOptions(locator);
		ArrayList<String> eleTextList = new ArrayList<String>();
		for (WebElement e : dropdownList) {
			String text = e.getText();
			if (text.length() != 0) {
				eleTextList.add(text);
			}

		}
		return eleTextList;
	}

	public void doSearch(By searchlocator, String searchKey, By suggLocator, String value) throws InterruptedException {
		getElement(searchlocator).sendKeys(searchKey);
		Thread.sleep(3000);

		List<WebElement> suggList = getElements(suggLocator);
		System.out.println(suggList.size() - 1);

		for (WebElement e : suggList) {
			System.out.println(e.getText());
			if (e.getText().equals(value)) {
				e.click();
				break;
			}
		}

	}

	public void doSearch(String tagname, String text) {
		By suggLocator = By.xpath("//" + tagname + "[text()='" + text + "']");
		getElement(suggLocator).click();
	}

}