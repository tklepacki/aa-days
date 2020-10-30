package stores.reserved.page;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.CustomFluentWait;

public class LoginPage {

	@FindBy(id = "login[username]_id")
	private WebElement emailTextField;

	@FindBy(id = "login[password]_id")
	private WebElement passwordTextField;

	@FindBy(xpath = "//div[@id='loginRegisterRoot']/div/div/div/form/button")
	private WebElement loginSubmitButton;

	private final CustomFluentWait customFluentWait;
	private static final Duration DEFAULT_TIMEOUT = Duration.ofSeconds(10);

	public LoginPage(WebDriver driver) {
		customFluentWait = new CustomFluentWait(driver);
	}

	private void typeEmail(String email) {
		emailTextField.sendKeys(email);
	}

	private void typePassword(String password) {
		passwordTextField.sendKeys(password);
	}

	private void clickLoginButton() {
		customFluentWait.clickElement(loginSubmitButton, DEFAULT_TIMEOUT);
	}

	public void loginUser(String email, String password) {
		customFluentWait.waitForElementDisplayed(emailTextField, DEFAULT_TIMEOUT);
		typeEmail(email);
		typePassword(password);
		clickLoginButton();
	}

}