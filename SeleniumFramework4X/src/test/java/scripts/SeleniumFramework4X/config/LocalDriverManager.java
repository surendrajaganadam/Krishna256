package scripts.SeleniumFramework4X.config;

import org.openqa.selenium.WebDriver;


/**
 * The Class LocalDriverManager.
 */
public class LocalDriverManager {

	/** The web driver. */
	private static ThreadLocal<WebDriver> webDriver = new ThreadLocal<WebDriver>();

	/**
	 * Gets the driver.
	 *
	 * @return the driver
	 */
	public static WebDriver getDriver() {
		return webDriver.get();
	}
	
	public static void setWebDriver(WebDriver driver) {
		webDriver.set(driver);
	}
	
	
	
	
}