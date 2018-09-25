package stores.reserved.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageObjectManager {

	private final WebDriver driver;
	private LoginPage loginPage;
	private UserMenuPage userMenuPage;
	private UserAccountPage userAccountPage;

	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}

	public LoginPage getLoginPage() {
		if (loginPage == null) {
			loginPage = PageFactory.initElements(driver, LoginPage.class);
		}
		return loginPage;
	}

	public UserMenuPage getUserMenuPage() {
		if (userMenuPage == null) {
			userMenuPage = PageFactory.initElements(driver, UserMenuPage.class);
		}
		return userMenuPage;
	}

	public UserAccountPage getUserAccountPage() {
		if (userAccountPage == null) {
			userAccountPage = PageFactory.initElements(driver, UserAccountPage.class);
		}
		return userAccountPage;
	}
}