package stores.mohito.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

	@FindBy(id = "login[username]_id")
	private WebElement emailTextField;

	@FindBy(id = "login[password]_id")
	private WebElement passwordTextField;

	@FindBy(xpath = "//div[@id='loginRegisterRoot']/div/div/div/form/button")
	private WebElement loginSubmitBtn;

	public void sendLogin(String email) {
		emailTextField.clear();
		emailTextField.sendKeys(email);
	}

	public void sendPassword(String password) {
		passwordTextField.clear();
		passwordTextField.sendKeys(password);
	}

	public void clickLoginBtn() {
		loginSubmitBtn.click();
	}

}