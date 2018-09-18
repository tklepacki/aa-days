package reserved.pl;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import driver.WebDriverCreator;
import reserved.pl.testdata.UserDataProvider;
import stores.reserved.commons.CommonTestSteps;
import stores.reserved.page.PageObjectManager;

public class LoginTest {

	private WebDriver driver;
	private CommonTestSteps commonTestSteps;
	private PageObjectManager manager;
	private static final String URL = "http://reserved.com/pl/pl";

	@Parameters("browser")
	@BeforeMethod
	public void setUp(String browser) {
		driver = new WebDriverCreator().createDriver(browser);
		commonTestSteps = new CommonTestSteps(driver);
		manager = new PageObjectManager(driver);
	}

	@Test(dataProvider = "loginTest", dataProviderClass = UserDataProvider.class)
	public void loginTest(String email, String password, String firstName) {

		commonTestSteps.loadMainPage(URL);
		commonTestSteps.loginUser(email, password);

		assertEquals(manager.getUserMenuPage().getAccountIconText(), firstName);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}