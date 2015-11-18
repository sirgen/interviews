package org.ti.interviews;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Utils class for web driver
 *
 */
public class WebDriverUtils {
	
	private static Map<WebBrowserType, WebDriver> webDrivers = new HashMap<>();

	/**
	 * Return default web driver (Firefox)
	 * 
	 * @return - WebDriver
	 */
	public static WebDriver getWebDriver() {
		
		return getWebDriver(WebBrowserType.Firefox);
	}
	
	/**
	 * Return singleton web driver instance for given browser type
	 * 
	 * @param browserType - type of web browser
	 * @return - WebDriver
	 */
	public static WebDriver getWebDriver(WebBrowserType browserType) {
		
		if (webDrivers.containsKey(browserType))
			return webDrivers.get(browserType);

		WebDriver driver = createNewWebDriver(browserType);
		webDrivers.put(browserType, driver);
		return driver;
	}
	
	/**
	 * Create new web driver instance for given browser type
	 * 
	 * @param browserType - type of web browser
	 * @return - WebDriver
	 */
	private static WebDriver createNewWebDriver(WebBrowserType browserType) {
		
		switch (browserType) {
			case Firefox:
				return new FirefoxDriver();
			default:
				throw new IllegalArgumentException("Browser not supported"); // TODO impl
		}
	}
}