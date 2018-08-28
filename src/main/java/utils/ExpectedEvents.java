package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class ExpectedEvents {
	private WebDriver driver;
	private String callerClassName;
	private Actions actions;

	public ExpectedEvents(WebDriver driver, String callerClassName) {
		this.driver = driver;
		this.callerClassName = callerClassName;
		actions = new Actions(driver);
	}

	public ExpectedCondition<Boolean> clickElement(final WebElement element) {
		return new ExpectedCondition<Boolean>() {

			@Override
			public Boolean apply(WebDriver input) {
				element.click();
				return true;
			}

			@Override
			public String toString() {
				return TimeoutExceptionMessage.getTimeoutMessage(driver, element, callerClassName);
			}
		};
	}

	public ExpectedCondition<String> getElementText(final WebElement element) {
		return new ExpectedCondition<String>() {

			@Override
			public String apply(WebDriver input) {
				return element.getText().isEmpty() ? null : element.getText();
			}

			@Override
			public String toString() {
				return TimeoutExceptionMessage.getTimeoutMessage(driver, element, callerClassName);
			}
		};
	}

	public ExpectedCondition<Boolean> moveToElementAndDisplayTarget(final WebElement moveToElement,
			final WebElement targetToBeDisplayedAfterMove) {
		return new ExpectedCondition<Boolean>() {

			@Override
			public Boolean apply(WebDriver input) {
				actions.moveToElement(moveToElement).perform();
				return targetToBeDisplayedAfterMove.isDisplayed();
			}

			@Override
			public String toString() {
				return TimeoutExceptionMessage.getTimeoutMessage(driver, targetToBeDisplayedAfterMove, callerClassName);
			}
		};
	}

	public ExpectedCondition<Boolean> elementToBeClickable(final By locator) {

		return driver -> {
			assert driver != null;
			WebElement visibleElement = driver.findElement(locator).isDisplayed() ? driver.findElement(locator) : null;
			try {
				return visibleElement != null && visibleElement.isEnabled();
			} catch (StaleElementReferenceException e) {
				return false;
			}
		};
	}

	public ExpectedCondition<Boolean> elementIsPresent(final WebElement element) {
		return new ExpectedCondition<Boolean>() {

			@Override
			public Boolean apply(WebDriver input) {
				return element.isDisplayed();
			}

			@Override
			public String toString() {
				return TimeoutExceptionMessage.getTimeoutMessage(driver, element, callerClassName);
			}
		};
	}

}