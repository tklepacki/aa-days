package mohito.pl;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import driver.WebDriverCreator;
import mohito.pl.testdata.UserDataProvider;
import stores.mohito.commons.CommonTestSteps;
import stores.mohito.page.PageObjectManager;

public class LoginTest {

	private WebDriver driver;
	private CommonTestSteps commonTestSteps;
	private PageObjectManager manager;
	private static final String URL = "http://mohito.com/pl/pl";

	@BeforeMethod
	@Parameters("browser")
	public void setUp(String browser)
 {
		driver = new WebDriverCreator().createDriver("chrome");
		commonTestSteps = new CommonTestSteps(driver);
		manager = new PageObjectManager(driver);
	}

	@Test(dataProvider = "loginTest", dataProviderClass = UserDataProvider.class)
	public void loginTest(String email, String password) {

		commonTestSteps.loadMainPage(URL);
		WebDriverCreator.setNewsletterCookie(driver);
		commonTestSteps.loginProcess(email, password);
		manager.getUserMenuPage().clickAccountIcon();

		assertTrue(manager.getUserAccountPage().isUserAccountPageDisplayed());
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}