package stores.mohito.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.CustomFluentWait;

public class UserAccountPage {

	@FindBy(xpath = "//*[@class=' customer-account-edit cms- js-enabled']")
	private WebElement userAccountPage;

	private CustomFluentWait customFluentWait;

	public UserAccountPage(WebDriver driver) {
		customFluentWait = new CustomFluentWait(driver);
	}

	public boolean isUserAccountPageDisplayed() {
		return customFluentWait.isElementPresent(userAccountPage);
	}

}