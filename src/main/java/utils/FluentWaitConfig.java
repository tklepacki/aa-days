package utils;

import java.time.Duration;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;

public class FluentWaitConfig {
	private static final Duration defaultTimeoutInSeconds = Duration.ofSeconds(30);
	private static final Duration defaultPollingInMilliseconds = Duration.ofMillis(500);

	public static FluentWait<WebDriver> loadConfig(FluentWait<WebDriver> wait, final Duration timeoutInSeconds) {
		configure(wait, timeoutInSeconds);
		return wait;
	}

	public static FluentWait<WebDriver> loadConfig(FluentWait<WebDriver> wait) {
		configure(wait, defaultTimeoutInSeconds);
		return wait;
	}

	private static void setPoolingPeriod(FluentWait<WebDriver> wait) {
		wait.pollingEvery(defaultPollingInMilliseconds);
	}

	private static void setTimeoutAfterSeconds(FluentWait<WebDriver> wait, final Duration timeoutInSeconds) {
		wait.withTimeout(timeoutInSeconds);
	}

	private static void addIgnoredExceptions(FluentWait<WebDriver> wait) {
		wait.ignoring(StaleElementReferenceException.class).ignoring(ElementNotVisibleException.class)
				.ignoring(NoSuchElementException.class).ignoring(InvalidElementStateException.class);
	}

	private static void configure(FluentWait<WebDriver> wait, final Duration timeoutInSeconds) {
		addIgnoredExceptions(wait);
		setTimeoutAfterSeconds(wait, timeoutInSeconds);
		setPoolingPeriod(wait);
	}

}
