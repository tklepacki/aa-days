package stores.reserved.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.CustomFluentWait;
import utils.Wait;

public class UserAccountPage {

	@FindBy(xpath = "/html/body/div[1]/section/div[2]/div/form/nav/ul/li[1]/a|/html/body/div[1]/section/div[2]/nav/ul/li[1]/a")
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