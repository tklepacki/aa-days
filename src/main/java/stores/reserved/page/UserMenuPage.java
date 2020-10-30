package stores.reserved.page;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.CustomFluentWait;

public class UserMenuPage {

	@FindBy(xpath = "//*[@data-selen='account-logged-out-button' or @data-selen='account-logged-in-button']")
	private WebElement accountIcon;

	private final CustomFluentWait customFluentWait;
	private static final Duration DEFAULT_TIMEOUT = Duration.ofSeconds(10);

	public UserMenuPage(WebDriver driver) {
		customFluentWait = new CustomFluentWait(driver);
	}

	public void clickAccountIcon() {
		customFluentWait.clickElement(accountIcon, DEFAULT_TIMEOUT);
	}

}