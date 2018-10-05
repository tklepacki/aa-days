package driver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverCreator {

	private static String CHROMEDRIVER_PATH = "src/main/resources/seleniumdrivers/chromedrivers/chromedriver-v2-41-linux64/chromedriver";
	private static String GECKODRIVER_PATH = "src/main/resources/seleniumdrivers/firefoxdrivers/geckodriver-v0-21-0-linux64/geckodriver";

	public WebDriver createDriver(String browser) {
		switch (browser) {
		case "firefox":
			if (System.getProperty("os.name").contains("Windows")) {
				GECKODRIVER_PATH = "src/main/resources/seleniumdrivers/firefoxdrivers/geckodriver-v0-21-0-win64/geckodriver.exe";
			} else if (System.getProperty("os.name").contains("Mac")) {
				GECKODRIVER_PATH = "src/main/resources/seleniumdrivers/firefoxdrivers/geckodriver-v0-21-0-macos/geckodriver";
			}
			System.setProperty("webdriver.gecko.driver", GECKODRIVER_PATH);
			WebDriver firefoxDriver = new FirefoxDriver();
			setDefaultSettings(firefoxDriver);
			return firefoxDriver;

		case "chrome":
			if (System.getProperty("os.name").contains("Windows")) {
				CHROMEDRIVER_PATH = "src/main/resources/seleniumdrivers/chromedrivers/chromedriver-v2-41-win32/chromedriver.exe";
			} else if (System.getProperty("os.name").contains("Mac")) {
				CHROMEDRIVER_PATH = "src/main/resources/seleniumdrivers/chromedrivers/chromedriver-v2-41-mac64/chromedriver";
			}
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--no-sandbox");
			System.setProperty("webdriver.chrome.driver", CHROMEDRIVER_PATH);
			WebDriver chromeDriver = new ChromeDriver(options);
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