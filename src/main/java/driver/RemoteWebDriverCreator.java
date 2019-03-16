package driver;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class RemoteWebDriverCreator {

    private DesiredCapabilities capabilities;

    public RemoteWebDriver createDriver(String browser) throws MalformedURLException {
        RemoteWebDriver driver;
        switch(browser) {
            case "chrome":
                capabilities = DesiredCapabilities.chrome();
                driver = new RemoteWebDriver(new URL("localhost:32768"), capabilities);
                setDefaultSettings(driver);
                return driver;
            case "firefox":
                capabilities = DesiredCapabilities.firefox();
                driver = new RemoteWebDriver(new URL("localhost:32679"), capabilities);
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
