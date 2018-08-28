package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TimeoutExceptionMessage {

	public static String getTimeoutMessage(WebDriver driver, WebElement element, String callerClassName) {
		return getCallerMethodFromStackTraceByClassName(callerClassName) + "\nElement: " + element + "\nurl: "
				+ getCurrentUrlMessage(driver);
	}
	
	public static String getCausedByMessage(Throwable lastException) {
		return (lastException != null) ? "\nCaused by: " + lastException.getClass().getName() : "";
	}

	private static String getCurrentUrlMessage(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	private static String getCallerMethodFromStackTraceByClassName(String callerClassName) {
		StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
		for (StackTraceElement element : stackTraceElements) {
			if (element.getClassName().contains(callerClassName))
				return element.getClassName() + "." + element.getMethodName();
		}
		return "";
	}

}