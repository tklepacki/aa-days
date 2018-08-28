package utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;

public class FluentWaitFactory {
	private final WebDriver driver;

	public FluentWaitFactory(WebDriver driver) {
		this.driver = driver;
	}

	public FluentWait<WebDriver> getCustomWait() {
		return FluentWaitConfig.loadConfig(createNewInstanceOfWait());
	}

	public FluentWait<WebDriver> getCustomWait(final Duration timeoutInSeconds) {
		return FluentWaitConfig.loadConfig(createNewInstanceOfWait(), timeoutInSeconds);
	}

	private FluentWait<WebDriver> createNewInstanceOfWait() {
		return new FluentWait<WebDriver>(driver) {
			@Override
			protected RuntimeException timeoutException(String message, Throwable lastException) {
				message = message + TimeoutExceptionMessage.getCausedByMessage(lastException);
				return super.timeoutException(message, lastException);
			}
		};
	}

}
