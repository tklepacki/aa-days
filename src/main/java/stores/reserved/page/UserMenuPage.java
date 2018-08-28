package stores.reserved.page;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.CustomFluentWait;

public class UserMenuPage {

	@FindBy(xpath = ".//*[@id='myAccountMenu']")
	private WebElement accountIcon;

	@FindBy(xpath = ".//*[@id='myAccountMenu']/a")
	private WebElement accountIconText;

	@FindBy(xpath = ".//*[@id='myAccountMenu']/ul/li[3]/a")
	private WebElement logoutIcon;

	private final CustomFluentWait customFluentWait;
	private static final Duration DEFAULT_TIMEOUT = Duration.ofSeconds(10);

	public UserMenuPage(WebDriver driver) {
		customFluentWait = new CustomFluentWait(driver);
	}

	public void clickAccountIcon() {
		customFluentWait.clickElement(accountIcon, DEFAULT_TIMEOUT);
	}

	public String getAccountIconText() {
		customFluentWait.waitForElementDisplayed(accountIcon, DEFAULT_TIMEOUT);
		return customFluentWait.getElementText(accountIconText, DEFAULT_TIMEOUT);
	}

	public void waitForUserLogin() {
		customFluentWait.moveToElementUntilTargetIsDisplayed(accountIcon, logoutIcon, DEFAULT_TIMEOUT);
	}

}