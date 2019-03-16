package driver;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class RemoteWebDriverCreator {

    private static final String GRID_URL = "http://localhost:4444/wd/hub";

    public RemoteWebDriver createDriver(String browser) throws MalformedURLException {
        RemoteWebDriver driver;
        switch(browser) {
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                driver = new RemoteWebDriver(new URL(GRID_URL), chromeOptions);
                setDefaultSettings(driver);
                return driver;
            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                driver = new RemoteWebDriver(new URL(GRID_URL), firefoxOptions);
                setDefaultSettings(driver);
                return driver;
            default:
                throw new IllegalArgumentException("Browser type undefined.");

        }
    }

    private static void setDefaultSettings(RemoteWebDriver driver) {
        driver.manage().window().setSize(new Dimension(1920, 1024));
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
    }

    public static void setNewsletterCookie(RemoteWebDriver driver) {
        Cookie newslettercookie = new Cookie("newsletterCookie", "4");
        driver.manage().addCookie(newslettercookie);
    }
}
