package mohito.de;

import driver.RemoteWebDriverCreator;
import mohito.de.testdata.UserDataProvider;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import stores.mohito.commons.CommonTestSteps;
import stores.mohito.page.PageObjectManager;

import static org.testng.Assert.assertTrue;

public class LoginTest {

	private RemoteWebDriver driver;
	private CommonTestSteps commonTestSteps;
	private PageObjectManager manager;
	private static final String URL = "http://mohito.com/de/de";

	@BeforeMethod
	@Parameters("browser")
	public void setUp(String browser) throws Exception {
//		driver = new WebDriverCreator().createDriver(browser);
		driver = new RemoteWebDriverCreator().createDriver(browser);
		commonTestSteps = new CommonTestSteps(driver);
		manager = new PageObjectManager(driver);
	}

	@Test(dataProvider = "loginTest", dataProviderClass = UserDataProvider.class)
	public void loginTest(String email, String password) {

		commonTestSteps.loadMainPage(URL);
		RemoteWebDriverCreator.setNewsletterCookie(driver);
		commonTestSteps.loginProcess(email, password);
		manager.getUserMenuPage().clickAccountIcon();

		assertTrue(manager.getUserAccountPage().isUserAccountPageDisplayed());
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}