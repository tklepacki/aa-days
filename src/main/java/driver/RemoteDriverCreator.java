package driver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class RemoteDriverCreator {

	public RemoteWebDriver createDriver(String browser) throws MalformedURLException {
		switch (browser) {
		case "firefox":
			FirefoxOptions firefoxOptions = new FirefoxOptions();
			RemoteWebDriver firefoxDriver = new RemoteWebDriver(new URL("http://192.168.99.100:4444/wd/hub"),
					firefoxOptions);
			setDefaultSettings(firefoxDriver);
			return firefoxDriver;
		case "chrome":
			ChromeOptions chromeOptions = new ChromeOptions();
			RemoteWebDriver chromeDriver = new RemoteWebDriver(new URL("http://192.168.99.100:4444/wd/hub"), chromeOptions);
			setDefaultSettings(chromeDriver);
			return chromeDriver;
		default:
			throw new IllegalArgumentException("The Browser Type is Undefined");
		}
	}

	private static void setDefaultSettings(WebDriver driver) {
		driver.manage().window().setSize(new Dimension(1920, 1024));
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
	}

	public static void setNewsletterCookie(WebDriver driver) {
		Cookie newslettercookie = new Cookie("newsletterCookie", "4");
		driver.manage().addCookie(newslettercookie);
	}

}