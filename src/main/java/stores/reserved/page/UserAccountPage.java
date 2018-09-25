package stores.reserved.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.CustomFluentWait;
import utils.Wait;

public class UserAccountPage {

	@FindBy(xpath = "//form[@id='customerAccountForm']/div")
	private WebElement userAccountPage;

	private final CustomFluentWait customFluentWait;

	public UserAccountPage(WebDriver driver) {
		customFluentWait = new CustomFluentWait(driver);
	}

	public boolean isUserAccountPageDisplayed() {
		Wait.waitForOneSecond();
		return customFluentWait.isElementPresent(userAccountPage);
	}

}