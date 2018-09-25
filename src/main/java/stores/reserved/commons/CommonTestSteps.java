package stores.reserved.commons;

import org.openqa.selenium.WebDriver;

import stores.reserved.page.PageObjectManager;

public class CommonTestSteps {

	private final PageObjectManager manager;
	private final WebDriver driver;

	public CommonTestSteps(WebDriver driver) {
		this.driver = driver;
		manager = new PageObjectManager(driver);
	}

	public void loadMainPage(String url) {
		driver.navigate().to(url);
	}

	public void loginUser(String email, String password) {
		manager.getUserMenuPage().clickAccountIcon();
		manager.getLoginPage().loginUser(email, password);
	}

}