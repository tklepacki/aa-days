package mohito.pl;

import driver.RemoteWebDriverCreator;
import mohito.pl.testdata.UserDataProvider;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import stores.mohito.commons.CommonTestSteps;
import stores.mohito.page.PageObjectManager;

import java.net.MalformedURLException;

import static org.testng.Assert.assertTrue;

public class LoginTest {

//	private WebDriver driver;
	private RemoteWebDriver driver;
	private CommonTestSteps commonTestSteps;
	private PageObjectManager manager;
	private static final String URL = "http://mohito.com/pl/pl";

	@BeforeMethod
	@Parameters("browser")
	public void setUp(String browser) throws MalformedURLException {
//		driver = new WebDriverCreator().createDriver(browser);
		driver = new RemoteWebDriverCreator().createDriver(browser);
		commonTestSteps = new CommonTestSteps(driver);
		manager = new PageObjectManager(driver);
	}

	@Test(dataProvider = "loginTest", dataProviderClass = UserDataProvider.class)
	public void loginTest(String email, String password) {

		commonTestSteps.loadMainPage(URL);
//		WebDriverCreator.setNewsletterCookie(driver);
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