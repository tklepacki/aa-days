package stores.mohito.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.CustomFluentWait;

public class UserMenuPage {

	@FindBy(xpath = "(//div[@id='aside-menu-right-login']/a/p)[2] | (//div[@id='aside-menu-right-customer']/a/p)[2]")
	private WebElement accountIcon;

	@FindBy(id = "acceptRulesSubmit")
	private WebElement acceptRules;

	private CustomFluentWait customFluentWait;

	public UserMenuPage(WebDriver driver) {
		customFluentWait = new CustomFluentWait(driver);
	}

	public void clickAccountIcon() {
		customFluentWait.clickElement(accountIcon);
	}

	public void clickAcceptRules() {
		customFluentWait.clickElement(acceptRules);
	}

}