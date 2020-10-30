package stores.mohito.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.CustomFluentWait;

public class UserMenuPage {

	@FindBy(xpath = "(//div[@id='aside-menu-right-login']/a/i)[2] | (//div[@id='aside-menu-right-customer']/a/i)[2]")

	private WebElement accountIcon;

	private CustomFluentWait customFluentWait;

	public UserMenuPage(WebDriver driver) {
		customFluentWait = new CustomFluentWait(driver);
	}

	public void clickAccountIcon() {
		customFluentWait.clickElement(accountIcon);
	}

}