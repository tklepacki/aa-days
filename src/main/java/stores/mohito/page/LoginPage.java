package stores.mohito.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

	@FindBy(id = "email")
	private WebElement emailTextField;

	@FindBy(id = "name")
	private WebElement passwordTextField;

	@FindBy(xpath = ".//*[@id='authorization']/div/input")
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