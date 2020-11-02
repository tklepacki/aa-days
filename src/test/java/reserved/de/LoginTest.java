package reserved.de;

import static org.testng.Assert.assertTrue;

import driver.RemoteDriverCreator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import driver.WebDriverCreator;
import reserved.de.testdata.UserDataProvider;
import stores.reserved.commons.CommonTestSteps;
import stores.reserved.page.PageObjectManager;

import java.net.MalformedURLException;

public class LoginTest {

	private WebDriver driver;
	private CommonTestSteps commonTestSteps;
	private PageObjectManager manager;
	private static final String URL = "http://reserved.com/de/de";

	@BeforeMethod
	public void setUp() throws MalformedURLException {
		driver = new RemoteDriverCreator().createDriver("firefox");
		commonTestSteps = new CommonTestSteps(driver);
		manager = new PageObjectManager(driver);
	}

	@Test(dataProvider = "loginTest", dataProviderClass = UserDataProvider.class)
	public void loginTest(String email, String password, String firstName) {

		commonTestSteps.loadMainPage(URL);
		WebDriverCreator.setNewsletterCookie(driver);
		commonTestSteps.loginUser(email, password);
		manager.getUserMenuPage().clickAccountIcon();

		assertTrue(manager.getUserAccountPage().isUserAccountPageDisplayed());
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}